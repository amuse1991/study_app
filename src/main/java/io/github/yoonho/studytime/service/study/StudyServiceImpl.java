package io.github.yoonho.studytime.service.study;

import io.github.yoonho.studytime.domain.membership.MembershipRepository;
import io.github.yoonho.studytime.domain.study.Study;
import io.github.yoonho.studytime.domain.study.StudyKeywords;
import io.github.yoonho.studytime.domain.study.StudyKeywordsRepository;
import io.github.yoonho.studytime.domain.study.StudyRepository;
import io.github.yoonho.studytime.dto.membership.MembershipInfoDto;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.dto.study.StudyInfoDto;
import io.github.yoonho.studytime.dto.study.UpdateStudyReqDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.exceptions.study.StudyNotFoundException;
import io.github.yoonho.studytime.service.membership.MembershipService;
import io.github.yoonho.studytime.service.membership.MembershipServiceImpl;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import io.github.yoonho.studytime.utils.types.MemberAuthType;
import javassist.compiler.ast.Keyword;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


@Transactional
@Service
@Slf4j
public class StudyServiceImpl implements StudyService {

    private int INITIAL_TEST_POINT = 100;
    private StudyRepository studyRepository;
    private StudyKeywordsRepository keywordsRepository;
    private MembershipServiceImpl membershipService;

    StudyServiceImpl(StudyRepository studyRepository, StudyKeywordsRepository keywordsRepository, MembershipServiceImpl membershipService){
        this.studyRepository = studyRepository;
        this.keywordsRepository = keywordsRepository;
        this.membershipService = membershipService;
    }

    @Override
    public StudyInfoDto createStudy(StudyCreateReqDto reqForm) {
        String creatorId = reqForm.getCreatorId();
        List<String> keywords = reqForm.getKeywords();
        String name = reqForm.getName();
        DayOfWeek dayOfWeek = reqForm.getDayOfWeek();
        Date time = reqForm.getTime();
        String description = reqForm.getDescription();
        Boolean enableAttendance = reqForm.getEnableAttendance();

        if(creatorId == null || name == null || dayOfWeek == null || time == null || enableAttendance == null){
            throw new IllegalArgumentException();
        }
        if(keywords.size() > 3){
            throw new IllegalArgumentException("Number of keywords cannot be more than 3");
        }

        // 스터디 저장
        Study newStudy = Study.builder()
                .name(name)
                .dayOfWeek(dayOfWeek)
                .time(time)
                .testPoint(INITIAL_TEST_POINT)
                .description(description)
                .enableAttendance(enableAttendance)
                .build();
        studyRepository.save(newStudy);

        List<String> keywordNames = new ArrayList<>();
        // 키워드 저장
        keywords.forEach(keyElem -> {
            StudyKeywords keyword = StudyKeywords.builder()
                    .name(keyElem)
                    .studyId(newStudy.getStudyId())
                    .build();
            keywordNames.add(keyword.getName());
            keywordsRepository.save(keyword);
        });

        // 스터디 생성자를 스터디에 가입시키고, 관리자 권한을 부여
        membershipService.createMembership(creatorId,newStudy.getStudyId(), MemberAuthType.manager);

        StudyInfoDto result = new StudyInfoDto();
        result.setName(newStudy.getName());
        result.setDayOfWeek(newStudy.getDayOfWeek());
        result.setTime(newStudy.getTime());
        result.setTestPoint(newStudy.getTestPoint());
        result.setDescription(newStudy.getDescription());
        result.setEnabelAttendacne(newStudy.getEnableAttendance());
        result.setKeywords(keywordNames);

        log.info("study created");
        log.info(result.toString());
        return result;
    }

    // TODO : 테스트
    @Override
    public StudyInfoDto getStudyByStudyId(Long studyId) {
        // 스터디 정보 조회
        Study study = studyRepository.findById(studyId)
                .orElseThrow(()->new StudyNotFoundException(studyId));
        // 키워드 정보 조회
        List<String> keywordNames = new ArrayList<>();
        List<StudyKeywords> keywords = keywordsRepository.findAllByStudyId(studyId);
        keywords.forEach(keyElem->{
            keywordNames.add(keyElem.getName());
        });

        StudyInfoDto result = new StudyInfoDto();
        result.setName(study.getName());
        result.setDayOfWeek(study.getDayOfWeek());
        result.setTime(study.getTime());
        result.setTestPoint(study.getTestPoint());
        result.setDescription(study.getDescription());
        result.setEnabelAttendacne(study.getEnableAttendance());
        result.setKeywords(keywordNames);

        return result;
    }

    // TODO : 테스트
    @Override
    public StudyInfoDto updateStudy(Long studyId, UpdateStudyReqDto updateForm) {
        // TODO : 권한 확인

        // 스터디 업데이트
        Study newStudy = studyRepository.findById(studyId)
                .orElseThrow(()->new StudyNotFoundException(studyId)); // 스터디 존재하지 않을 경우 에러
        newStudy.setName(updateForm.getName());
        newStudy.setDayOfWeek(updateForm.getDayOfWeek());
        newStudy.setTime(updateForm.getTime());
        newStudy.setDescription(updateForm.getDescription());
        if(updateForm.isEnabelAttendacne()){
            newStudy.enableAttendance();
        }else{
            newStudy.disableAttendance();
        }
        studyRepository.save(newStudy);

        // 키워드 삭제 후 재입력
        List<String> keywordNames = new ArrayList<>(); // result에 키워드 이름 반환할 때 사용
        keywordsRepository.deleteAllByStudyId(studyId);
        updateForm.getKeywords().forEach(keyElem -> {
            StudyKeywords keyword = StudyKeywords.builder()
                    .name(keyElem)
                    .studyId(studyId)
                    .build();
            keywordNames.add(keyword.getName());
            keywordsRepository.save(keyword);
        });

        StudyInfoDto result = new StudyInfoDto();
        result.setName(newStudy.getName());
        result.setDayOfWeek(newStudy.getDayOfWeek());
        result.setTime(newStudy.getTime());
        result.setTestPoint(newStudy.getTestPoint());
        result.setDescription(newStudy.getDescription());
        result.setEnabelAttendacne(newStudy.getEnableAttendance());
        result.setKeywords(keywordNames);

        log.info("study updated");
        log.info(result.toString());
        return result;
    }

    // TODO : 테스트
    @Override
    public String deleteStudy(Long studyId) {
        // TODO : 권한 확인

        // 스터디가 존재하는지 확인
        if(!studyRepository.existsById(studyId)){
            throw new StudyNotFoundException(studyId);
        }

        // 스터디 삭제
        studyRepository.deleteById(studyId);
        return studyId.toString();
    }
}

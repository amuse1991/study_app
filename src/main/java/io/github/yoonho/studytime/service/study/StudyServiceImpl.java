package io.github.yoonho.studytime.service.study;

import io.github.yoonho.studytime.domain.membership.MembershipRepository;
import io.github.yoonho.studytime.domain.study.Study;
import io.github.yoonho.studytime.domain.study.StudyKeywords;
import io.github.yoonho.studytime.domain.study.StudyKeywordsRepository;
import io.github.yoonho.studytime.domain.study.StudyRepository;
import io.github.yoonho.studytime.dto.study.StudyInfoDto;
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
    public StudyInfoDto createStudy(String creatorId, List<String> keywords, String name, DayOfWeek dayOfWeek, Date time, String description, Boolean enableAttendance) {
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
}

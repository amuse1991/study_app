package io.github.yoonho.studytime.api.study;

import io.github.yoonho.studytime.dto.membership.MembershipInfoDto;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.dto.study.StudyInfoDto;
import io.github.yoonho.studytime.dto.study.UpdateStudyReqDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.service.study.StudyServiceImpl;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudyApi {

    private StudyServiceImpl studyService;

    public StudyApi(StudyServiceImpl studyService) {
        this.studyService = studyService;
    }

    @PostMapping("/studies") // 스터디 생성
    public StudyInfoDto createStudy(@RequestBody StudyCreateReqDto reqForm){
        return studyService.createStudy(reqForm);
    }

    @GetMapping("/studies") // 스터디 검색
    public List<StudyInfoDto> searchStudy(
            @RequestParam(value = "studyId", required = false)String studyId,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "dayOfWeek", required = false)String dayOfWeek,
            @RequestParam(value = "time", required = false)String time,
            @RequestParam(value = "keywords", required = false)List<String> keywords,
            @RequestParam(value = "startAt",defaultValue = "0") int startAt,
            @RequestParam(value = "maxResult", defaultValue = "50")int maxResult){

        return null;
    }

    // single item

    @GetMapping("/studies/{studyId}") // 스터디 정보 조회
    public StudyInfoDto getStudyByStudyId(@PathVariable String studyId){
        return null;
    }

    @PutMapping("/studies/{studyId}") // 스터디 정보 수정
    public StudyInfoDto updateStudy(@PathVariable String studyId,
                                    @RequestBody UpdateStudyReqDto updateForm){
        return null;
    }

    @DeleteMapping("/studies/{studyId}") // 스터디 삭제
    public String deleteStudy(@PathVariable String studyId){
        return null;
    }

    // member
    @PostMapping("/studies/{studyId}") // 스터디에 멤버 추가
    public MembershipInfoDto addMember(@PathVariable String studyId,
                                            @RequestBody String userId){

        return null;
    }

    @GetMapping("/studies/{studyId}/members") // 스터디 멤버 조회
    public List<UserInfoResDto> getMembers(@PathVariable String studyId,
                                              @RequestParam(value = "userId",required = false) String userId,
                                              @RequestParam(value = "startAt",defaultValue = "0") int startAt,
                                              @RequestParam(value = "maxResult",defaultValue = "50") int maxResult,
                                              @RequestParam(value = "includeWaitingMembers",defaultValue = "false")boolean includeWaitingMembers){
        // if userId != null : 한명의 멤버 조회
        // else : 유저 목록 조회
        return null;
    }

    @DeleteMapping("/studies/{studyId}/members") // 스터디에서 멤버 제거
    public UserInfoResDto removeUserFromStudy(@PathVariable String studyId,
                                              @RequestParam String userName){
        return null;
    }
}

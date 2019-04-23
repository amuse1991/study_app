package io.github.yoonho.studytime.service.study;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.dto.membership.MembershipInfoDto;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.dto.study.StudyInfoDto;
import io.github.yoonho.studytime.dto.study.UpdateStudyReqDto;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;
import io.github.yoonho.studytime.utils.types.DayOfWeek;

import java.util.Date;
import java.util.List;

public interface StudyService {

    StudyInfoDto createStudy(StudyCreateReqDto reqForm);

//    List<StudyInfoDto> searchStudy(String name, String dayOfWeek, String time,
//                                    List<String> keywords, int startAt, int maxResult);
//
//    List<StudyInfoDto> searchStudyByName(String name, String dayOfWeek, String time,
//                                   List<String> keywords, int startAt, int maxResult);
//
//    List<StudyInfoDto> searchStudyByDayOfWeek(String dayOfWeek, int startAt, int maxResult );
//
//    List<StudyInfoDto> searchStudyByTime(String time, int startAt, int maxResult);
//
//    List<StudyInfoDto> searchStudyByKeywords(List<String> keywords, int startAt, int maxResult );

    StudyInfoDto getStudyByStudyId(Long studyId);

    StudyInfoDto updateStudy(Long studyId, UpdateStudyReqDto updateForm);

    String deleteStudy(Long studyId);

//    MembershipInfoDto addMemeber(Long studyId, String userId);
//
//    List<UserInfoResDto> getMembers(Long studyId, String userId,
//                                    int startAt, int maxResult,
//                                    boolean includeWaitingMembers);
//
//    UserInfoResDto removeUserFromStudy(Long studyId, String userId);

}

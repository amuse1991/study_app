package io.github.yoonho.studytime.service.study;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.dto.study.StudyInfoDto;
import io.github.yoonho.studytime.utils.types.DayOfWeek;

import java.util.Date;
import java.util.List;

public interface StudyService {
    StudyInfoDto createStudy(StudyCreateReqDto reqForm);

}

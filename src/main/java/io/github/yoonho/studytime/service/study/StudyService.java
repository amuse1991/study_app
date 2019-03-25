package io.github.yoonho.studytime.service.study;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.dto.study.StudyInfoDto;
import io.github.yoonho.studytime.utils.types.DayOfWeek;

import java.util.Date;
import java.util.List;

public interface StudyService {
    StudyInfoDto createStudy(String creatorId, List<String> keywords, String name, DayOfWeek dayOfWeek, Date time, String description, Boolean enableAttendance);

}

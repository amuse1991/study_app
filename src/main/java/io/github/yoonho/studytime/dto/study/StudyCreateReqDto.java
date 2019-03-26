package io.github.yoonho.studytime.dto.study;

import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class StudyCreateReqDto {
    private String creatorId;
    private List<String> keywords;
    private String name;
    private DayOfWeek dayOfWeek;
    private Date time;
    private String description;
    private Boolean enableAttendance;

    @Override
    public String toString() {
        return "StudyCreateReqDto{" +
                "creatorId='" + creatorId + '\'' +
                ", keyowrds=" + keywords +
                ", name='" + name + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", enabelAttendance=" + enableAttendance +
                '}';
    }
}

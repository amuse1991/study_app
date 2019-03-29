package io.github.yoonho.studytime.dto.study;

import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class UpdateStudyReqDto {
    private String name;
    private DayOfWeek dayOfWeek;
    private Date time;
    private String description;
    private boolean enabelAttendacne;
    private List<String> keywords;

    @Override
    public String toString() {
        return "UpdateStudyReqDto{" +
                "name='" + name + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", enabelAttendacne=" + enabelAttendacne +
                ", keywords=" + keywords +
                '}';
    }
}

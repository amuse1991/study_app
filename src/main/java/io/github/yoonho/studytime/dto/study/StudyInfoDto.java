package io.github.yoonho.studytime.dto.study;

import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class StudyInfoDto {
    private Long studyId;
    private String name;
    private DayOfWeek dayOfWeek;
    private Date time;
    private int testPoint;
    private String description;
    private boolean enabelAttendacne;
    private List<String> keywords;

    @Override
    public String toString() {
        return "StudyInfoDto{" +
                "studyId=" + studyId +
                ", name='" + name + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", time=" + time +
                ", testPoint=" + testPoint +
                ", description='" + description + '\'' +
                ", enabelAttendacne=" + enabelAttendacne +
                ", keywords=" + keywords +
                '}';
    }
}

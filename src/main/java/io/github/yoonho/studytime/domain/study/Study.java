package io.github.yoonho.studytime.domain.study;

import io.github.yoonho.studytime.exceptions.BelowDomainValueException;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@DynamicUpdate
@Table(name="study")
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_id")
    private Long studyId;

    @Column(nullable = false)
    private String name;

    @Column(name = "day_of_week", nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(nullable = false)
    private Date time;

    @Column(name = "test_point",nullable = false, columnDefinition = "default 0")
    private Integer testPoint;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "enable_attendance_check",columnDefinition = "default 0")
    private Boolean enableAttendance;

    @Builder
    public Study(String name, DayOfWeek dayOfWeek, Date time, Integer testPoint, String description, Boolean enableAttendance){
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.testPoint = testPoint;
        this.description = description;
        this.enableAttendance = enableAttendance;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void increaseTestPoint(Integer point){
        this.testPoint += point;
    }

    public void decreaseTestPoint(Integer point){
        int resPoint = this.testPoint - point;
        if(resPoint<0){
            throw new BelowDomainValueException(Integer.toString(resPoint),Integer.toString(0));
        }
        this.testPoint = resPoint;
    }

    public void enableAttendance(){
        this.enableAttendance = true;
    }

    public void disableAttendance(){
        this.enableAttendance = false;
    }

    @Override
    public String toString() {
        return "Study{" +
                "studyId=" + studyId +
                ", name='" + name + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", time=" + time +
                ", testPoint=" + testPoint +
                ", description='" + description + '\'' +
                ", enableAttendanceCheck=" + enableAttendance +
                '}';
    }
}

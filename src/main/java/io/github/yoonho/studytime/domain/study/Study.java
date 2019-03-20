package io.github.yoonho.studytime.domain.study;

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

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "day_of_week", nullable = false)
    private Date dayOfWeek;

    @Column(nullable = false)
    private Date time;

    @Column(name = "test_point",nullable = false, columnDefinition = "default 0")
    private Integer testPoint;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "enable_attendance_check",columnDefinition = "default 0")
    private Integer enableAttendanceCheck;

    @Builder
    public Study(String name, Date dayOfWeek, Date time, Integer testPoint, String description, Integer enableAttendanceCheck){
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.testPoint = testPoint;
        this.description = description;
        this.enableAttendanceCheck = enableAttendanceCheck;
    }
}

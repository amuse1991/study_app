package io.github.yoonho.studytime.domain.study;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name="study")
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long study_id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Date day_of_week;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false, columnDefinition = "default 0")
    private Integer test_point;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "default 0")
    private Integer enable_attendance_check;

    @Builder
    public Study(String name, Date day_of_week, Date time, Integer test_point, String description, Integer enable_attendance_check){
        this.name = name;
        this.day_of_week = day_of_week;
        this.time = time;
        this.test_point = test_point;
        this.description = description;
        this.enable_attendance_check = enable_attendance_check;
    }
}

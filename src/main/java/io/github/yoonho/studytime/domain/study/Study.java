package io.github.yoonho.studytime.domain.study;

import lombok.AccessLevel;
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
    private Date study_date;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false, columnDefinition = "default 0")
    private Integer test_point;

    @Column(columnDefinition = "TEXT")
    private String description;
    private Long study_type_id;
    private Long attendance_configure_id;

}

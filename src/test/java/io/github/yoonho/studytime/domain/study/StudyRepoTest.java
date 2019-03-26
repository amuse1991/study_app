package io.github.yoonho.studytime.domain.study;

import io.github.yoonho.studytime.StudytimeApplication;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest // 인메모리 DB생성, @entity 클래스만 스캔, @Transactional 어노테이션 포함
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //인메모리 DB 사용 안함
public class StudyRepoTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private StudyRepository studyRepository;

    @Test
    public void 스터디_저장_불러오기(){
        //given
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        dateFormat.format(time);

        Study newStudy = Study.builder()
                .name("테스트 스터디")
                .dayOfWeek(DayOfWeek.sun)
                .description("테스트용 스터디입니다.")
                .testPoint(10)
                .time(time)
                .enableAttendance(true)
                .build();

        //when
        studyRepository.save(newStudy);

        //then
        List<Study> studyList = studyRepository.findByName("테스트 스터디");
        Study study = studyList.get(0);
        assertThat(study.getName(),is("테스트 스터디"));
        assertThat(study.getDayOfWeek(),is(DayOfWeek.sun));
        assertThat(study.getDescription(),is("테스트용 스터디입니다."));
        assertThat(study.getTestPoint(),is(10));
        assertThat(study.getTime(),is(time));
        assertThat(study.getEnableAttendance(),is(true));
    }
}

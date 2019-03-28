package io.github.yoonho.studytime.service.study;

import io.github.yoonho.studytime.domain.membership.MemberAuth;
import io.github.yoonho.studytime.domain.membership.MemberAuthRepository;
import io.github.yoonho.studytime.domain.membership.MembershipRepository;
import io.github.yoonho.studytime.domain.study.Study;
import io.github.yoonho.studytime.domain.study.StudyKeywords;
import io.github.yoonho.studytime.domain.study.StudyKeywordsRepository;
import io.github.yoonho.studytime.domain.study.StudyRepository;
import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import io.github.yoonho.studytime.utils.types.MemberAuthType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyServiceTest {
    @Autowired
    private StudyServiceImpl studyService;
    @Autowired
    private StudyRepository studyRepository;
    @Autowired
    private StudyKeywordsRepository keywordsRepository;
    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private MemberAuthRepository memberAuthRepository;
    @Autowired
    private UsersRepository usersRepository;

    private StudyCreateReqDto studyCreateReq;

    @Before
    public void setUp(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        dateFormat.format(time);

        this.studyCreateReq = new StudyCreateReqDto();
        this.studyCreateReq.setCreatorId("estrella917@naver.com");
        this.studyCreateReq.setName("테스트 스터디");
        this.studyCreateReq.setDayOfWeek(DayOfWeek.sun);
        this.studyCreateReq.setDescription("this is test");
        this.studyCreateReq.setEnableAttendance(true);
        this.studyCreateReq.setTime(time);
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("test keyword1");
        keywords.add("test keyword2");
        this.studyCreateReq.setKeywords(keywords);

    }

    @Test
    @Transactional
    public void 스터디를_생성하면_새로운_스터디가_DB에_저장된다(){
        //given

        //when
        studyService.createStudy(studyCreateReq);

        //then
        List<Study> studyList = studyRepository.findByName("테스트 스터디");
        Study study = studyList.get(0);
        assertThat(study.getName(),is("테스트 스터디"));
    }

    @Test
    @Transactional
    public void 스터디를_생성하면_keyword가_DB에_저장된다(){
        //given

        //when
        studyService.createStudy(studyCreateReq);

        //then
        Long studyId = studyRepository.findByName("테스트 스터디").get(0).getStudyId();
        List<StudyKeywords> keys = keywordsRepository.findAllByStudyId(studyId);

        assertThat(keys.size(),is(2));
        assertThat(keys.get(0).getName(),anyOf(is("test keyword1"),is("test keyword2")));
    }

    @Test
    @Transactional
    public void 스터디를_생성하면_생성한_유저에게_스터디관리자_권한이_부여된다(){
        //given
        //TODO : 테스트 코드 작성
        //when
        studyService.createStudy(studyCreateReq);
        //then
        Users user = usersRepository.findUsersByUserId(studyCreateReq.getCreatorId());
        MemberAuth auth = memberAuthRepository.getAuthByUserKey(user.getUserKey());
        assertThat(auth.getName(),is(MemberAuthType.manager.toString()));
    }
}

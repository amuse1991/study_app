package io.github.yoonho.studytime.domain.authority;

import io.github.yoonho.studytime.domain.membership.MemberAuth;
import io.github.yoonho.studytime.domain.membership.MemberAuthRepository;
import io.github.yoonho.studytime.domain.study.Study;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.service.study.StudyServiceImpl;
import io.github.yoonho.studytime.service.users.UsersServiceImpl;
import io.github.yoonho.studytime.utils.types.AuthorityName;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberAuthRepoTest {

//    @Autowired
//    private MemberAuthRepository memberAuthRepository;
//    @Autowired
//    private UsersRepository usersRepository;
//    @Autowired
//    private UsersServiceImpl usersService;
//    @Autowired
//    private StudyServiceImpl studyService;
//
//    @Before
//    public void setUp(){
//        // 사용자 생성(study 생성하는 사람)
//        UserInsertReqDto user = new UserInsertReqDto();
//        user.setUserId("estrella917@naver.com");
//        user.setNickname("tester");
//        user.setPassword("111");
//        user.setPhone("010-111-111");
//        user.setPoint(0);
//        user.setAuthority(AuthorityName.user);
//        // db에 사용자 생성
//        usersService.createUser(user);
//
//        // 스터디 생성
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//        Date time = new Date();
//        dateFormat.format(time);
//        StudyCreateReqDto study = new StudyCreateReqDto();
//        study.setCreatorId("estrella917@naver.com");
//        study.setName("테스트 스터디");
//        study.setDayOfWeek(DayOfWeek.sun);
//        study.setDescription("this is test");
//        study.setEnableAttendance(true);
//        study.setTime(time);
//        ArrayList<String> keywords = new ArrayList<>();
//        keywords.add("test keyword1");
//        keywords.add("test keyword2");
//        study.setKeywords(keywords);
//
//        //db에 study 생성 (+membership 생성)
//        studyService.createStudy(study);
//    }
//
//    @Test
//    @Transactional
//    public void getAuthByUserKey함수는_userKey를_인자로_MemberAuth를_반환한다(){
//        //given
//        Long userKey = usersRepository.findUsersByUserId("extrella917@naver.com").getUserKey();
//        MemberAuth memberAuth = memberAuthRepository.getAuthByUserKey(userKey);
//        System.out.println(memberAuth.toString());
//    }
}

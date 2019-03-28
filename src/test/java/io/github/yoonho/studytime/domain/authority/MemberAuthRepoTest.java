package io.github.yoonho.studytime.domain.authority;

import io.github.yoonho.studytime.domain.membership.MemberAuth;
import io.github.yoonho.studytime.domain.membership.MemberAuthRepository;
import io.github.yoonho.studytime.domain.study.Study;
import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.study.StudyCreateReqDto;
import io.github.yoonho.studytime.dto.users.UserInsertReqDto;
import io.github.yoonho.studytime.service.study.StudyServiceImpl;
import io.github.yoonho.studytime.service.users.UsersServiceImpl;
import io.github.yoonho.studytime.utils.types.AuthorityName;
import io.github.yoonho.studytime.utils.types.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest //@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class MemberAuthRepoTest {

    @Autowired
    private MemberAuthRepository memberAuthRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private StudyServiceImpl studyService;

    @Test
    @Transactional
    public void getAuthByUserKey_userKey를_인자로_MemberAuth를_반환한다(){
        //given
//        Users user = Users.builder()
//                .userId("estrella917@naver.com")
//                .password("111")
//                .nickname("테스터")
//                .phone("010-1111-2222")
//                .point(0)
//                .authority(AuthorityName.user)
//                .build();

        Users user = usersRepository.findUsersByUserId("estrella917@naver.com");

        List<String> keywords = new ArrayList<>();
        keywords.add("TDD");
        keywords.add("Unit test");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        dateFormat.format(time);

        StudyCreateReqDto request = new StudyCreateReqDto();
        request.setCreatorId(user.getUserId());
        request.setKeywords(keywords);
        request.setName("테스트 스터디");
        request.setDayOfWeek(DayOfWeek.sun);
        request.setTime(time);
        request.setDescription("테스트 스터디 입니다.");
        request.setEnableAttendance(true);

        usersRepository.save(user);
        studyService.createStudy(request);

        //when
        MemberAuth auth = memberAuthRepository.getAuthByUserKey(user.getUserKey());
        //then
        assertNotNull(auth);
        assertThat(MemberAuth.class.getSimpleName(),is("MemberAuth"));
        log.info("MemberAuth:{}",auth);
        log.info("test");
    }
}

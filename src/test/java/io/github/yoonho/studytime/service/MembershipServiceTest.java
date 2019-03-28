package io.github.yoonho.studytime.service;

import io.github.yoonho.studytime.domain.membership.Membership;
import io.github.yoonho.studytime.domain.membership.MembershipRepository;
import io.github.yoonho.studytime.domain.study.StudyRepository;
import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.membership.MembershipInfoDto;
import io.github.yoonho.studytime.service.membership.MembershipService;
import io.github.yoonho.studytime.service.membership.MembershipServiceImpl;
import io.github.yoonho.studytime.utils.types.MemberAuthType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembershipServiceTest {

    @Autowired
    private MembershipServiceImpl membershipService;

    @MockBean(name = "usersRepository") //name에 mock 할 bean명을 명시해주어야 한다.
    private UsersRepository usersRepository;
    @MockBean(name = "studyRepository")
    private StudyRepository studyRepository;
    @MockBean(name="membershipRepository")
    private MembershipRepository membershipRepository;

    @Test
    public void createMembership_멤버쉽을_생성후_반환한다(){
        //given
        String userId = "amuse1991@gmail.com";
        Long userKey = 1L;
        Long studyId = 2L;


        Users user = Users.builder()
                .userKey(userKey)
                .userId(userId)
                .build();

        given(usersRepository.existsByUserId(userId))
                .willReturn(true);
        given(studyRepository.existsById(studyId))
                .willReturn(true);
        given(usersRepository.findUsersByUserId(userId))
                .willReturn(user);
        given(membershipRepository.save(any(Membership.class)))
                .willReturn(null);

        //when
        MembershipInfoDto membershipInfo = membershipService.createMembership(userId,studyId, MemberAuthType.manager);

        //then
        assertThat(membershipInfo.getUserId(),is(userId));
        assertThat(membershipInfo.getStudyId(),is(studyId));
        assertThat(membershipInfo.getAuthName(),is(MemberAuthType.manager.toString()));
    }

}

package io.github.yoonho.studytime.service.membership;

import io.github.yoonho.studytime.domain.membership.MemberAuth;
import io.github.yoonho.studytime.domain.membership.MemberAuthRepository;
import io.github.yoonho.studytime.domain.membership.Membership;
import io.github.yoonho.studytime.domain.membership.MembershipRepository;
import io.github.yoonho.studytime.domain.study.StudyRepository;
import io.github.yoonho.studytime.domain.users.UsersRepository;
import io.github.yoonho.studytime.dto.membership.MemberAuthDto;
import io.github.yoonho.studytime.dto.membership.MembershipInfoDto;
import io.github.yoonho.studytime.exceptions.membership.MemberAuthNotFoundException;
import io.github.yoonho.studytime.exceptions.study.StudyNotFoundException;
import io.github.yoonho.studytime.exceptions.users.UserNotFoundException;
import io.github.yoonho.studytime.utils.types.MemberAuthType;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService{


    private MembershipRepository membershipRepository;
    private MemberAuthRepository memberAuthRepository;
    private UsersRepository usersRepository;
    private StudyRepository studyRepository;
    private MemberAuthType DEFAULT_MEMBER_AUTH = MemberAuthType.waiting;

    MembershipServiceImpl(MembershipRepository membershipRepository, MemberAuthRepository memberAuthRepository, UsersRepository usersRepository, StudyRepository studyRepository){
        this.membershipRepository = membershipRepository;
        this.memberAuthRepository = memberAuthRepository;
        this.usersRepository = usersRepository;
        this.studyRepository = studyRepository;
    }

    @Override
    public MembershipInfoDto createMembership(String userId, Long studyId, MemberAuthType authType) {
        if(!usersRepository.existsByUserId(userId)){
            throw new UserNotFoundException(userId);
        }
        if(!studyRepository.existsById(studyId)){
            throw new StudyNotFoundException(studyId);
        }

        Long authId = getAuthIdByName(authType.toString());
        Long userKey = usersRepository.findUsersByUserId(userId).getUserKey();

        Membership newMembership =  Membership.builder()
                .authId(authId)
                .studyId(studyId)
                .userKey(userKey)
                .build();

        membershipRepository.save(newMembership);

        MembershipInfoDto result = new MembershipInfoDto();
        result.setUserId(userId);
        result.setStudyId(studyId);
        result.setAuthName(authType.toString());
        return result;
    }

    @Override
    public MemberAuthDto getMemberAuthByUserId(String userId) {

        return null;
    }

    @Override
    public MemberAuthDto changeMemberAuth(String userId, MemberAuthType auth) {
        return null;
    }

    private Long getAuthIdByName(String authName){
        MemberAuth memberAuth = memberAuthRepository.findByName(authName);
        if(memberAuth == null){
            throw new MemberAuthNotFoundException(authName);
        }
        return memberAuth.getAuthId();
    }
}

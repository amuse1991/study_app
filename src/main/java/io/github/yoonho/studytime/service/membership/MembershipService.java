package io.github.yoonho.studytime.service.membership;

import io.github.yoonho.studytime.domain.membership.Membership;
import io.github.yoonho.studytime.dto.membership.MemberAuthDto;
import io.github.yoonho.studytime.dto.membership.MembershipInfoDto;
import io.github.yoonho.studytime.utils.types.MemberAuthType;

public interface MembershipService {
    MembershipInfoDto createMembership(String userId, Long studyId, MemberAuthType auth);
    MemberAuthDto getMemberAuthByUserId(String userId);
    MemberAuthDto changeMemberAuth(String userId, MemberAuthType auth);
}

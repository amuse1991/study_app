package io.github.yoonho.studytime.dto.membership;

import io.github.yoonho.studytime.utils.types.MemberAuthType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberAuthDto {
    private String userId;
    private MemberAuthType auth;

    @Override
    public String toString() {
        return "MemberAuthDto{" +
                "userId='" + userId + '\'' +
                ", auth=" + auth +
                '}';
    }
}

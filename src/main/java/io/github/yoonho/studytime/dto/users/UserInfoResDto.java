package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResDto {
    private String userId;
    private String nickname;
    private String phone;
    private Integer point;
    private AuthorityName authority;
}

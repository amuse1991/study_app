package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDto {
    private String userId;
    private AuthorityName authority;
}

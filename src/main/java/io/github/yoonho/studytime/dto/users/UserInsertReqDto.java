package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserInsertReqDto {
    private String userId;
    private String password;
    private String nickname;
    private String phone;
    private Integer point;
    private AuthorityName authority;

    @Override
    public String toString() {
        return "UserInsertReqDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", point=" + point +
                ", authority=" + authority +
                '}';
    }
}

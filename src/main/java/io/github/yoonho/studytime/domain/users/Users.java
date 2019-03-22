package io.github.yoonho.studytime.domain.users;

import io.github.yoonho.studytime.exceptions.BelowDomainValueException;
import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용하기 위해 추가
@Getter
@Entity
@DynamicUpdate
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "user_key", updatable = false)
    private Long userKey;

    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(columnDefinition = "default 0")
    private Integer point;

    @Column(columnDefinition = "default user")
    @Enumerated(EnumType.STRING)
    private AuthorityName authority;
    private String phone;

    @Builder
    public Users(String userId, String password, String nickname, Integer point, String phone, AuthorityName authority){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.point = point;
        this.phone = phone;
        this.authority = authority;
    }

    public void updatePassword(String password){
        this.password = password;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateAuthority(AuthorityName authority) {
        this.authority = authority;
    }

    public void increasePoint(int value){
        this.point += value;
    }

    public void decreasePoint(int value) throws BelowDomainValueException{
        int updatedPoint = this.point + value;
        // 변경된 값이 0보다 작은 경우
        if(updatedPoint<0){
            throw new BelowDomainValueException(Integer.toString(value),Integer.toString(0));
        }
        this.point -= value;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userKey=" + userKey +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", point=" + point +
                ", authority=" + authority +
                ", phone='" + phone + '\'' +
                '}';
    }
}

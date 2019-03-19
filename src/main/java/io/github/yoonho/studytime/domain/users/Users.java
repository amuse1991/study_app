package io.github.yoonho.studytime.domain.users;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용하기 위해 추가
@Getter
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long user_key;

    @Column(nullable = false, unique = true)
    private String user_id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(columnDefinition = "default 0")
    private Integer point;

    @Column(columnDefinition = "default user")
    private String authority;
    private String phone;

    @Builder
    public Users(String user_id, String password, String nickname, Integer point, String phone, String authority){
        this.user_id = user_id;
        this.password = password;
        this.nickname = nickname;
        this.point = point;
        this.phone = phone;
        this.authority = authority;
    }
}

package io.github.yoonho.studytime.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    private String phone;
    private String authority;

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

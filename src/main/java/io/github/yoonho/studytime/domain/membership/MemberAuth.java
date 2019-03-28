package io.github.yoonho.studytime.domain.membership;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity
@Table(name="member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Long authId;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @Builder
    public MemberAuth(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MemberAuth{" +
                "authId=" + authId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

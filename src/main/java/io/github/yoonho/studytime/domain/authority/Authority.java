package io.github.yoonho.studytime.domain.authority;

import io.github.yoonho.studytime.utils.types.AuthorityName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@DynamicUpdate
@Table(name = "authority")
public class Authority {
    @Id
    @Enumerated(EnumType.STRING)
    private AuthorityName name;
    private String description;

    @Builder
    public Authority(AuthorityName name, String description){
        this.name = name;
        this.description = description;
    }
}

package io.github.yoonho.studytime.domain.authority;

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
    private String name;
    private String description;

    @Builder
    public Authority(String name, String description){
        this.name = name;
        this.description = description;
    }
}

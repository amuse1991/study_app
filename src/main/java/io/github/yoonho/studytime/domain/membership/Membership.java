package io.github.yoonho.studytime.domain.membership;

import io.github.yoonho.studytime.utils.types.MemberAuthType;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Entity
@Table(name = "membership")
public class Membership {
    @Id
    @Column(name = "user_key")
    private Long userKey;

    @Column(name = "study_id",unique = true,nullable = false)
    private Long studyId;

    @Column(name = "auth_id", unique = true, nullable = false)
    private Long authId;

    @Builder
    public Membership(Long userKey, Long studyId, Long authId){
        this.userKey = userKey;
        this.studyId = studyId;
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "userKey=" + userKey +
                ", studyId=" + studyId +
                ", authId=" + authId +
                '}';
    }
}

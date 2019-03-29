package io.github.yoonho.studytime.dto.membership;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MembershipInfoDto {
    private String userId;
    private Long studyId;
    private String studyName;
    private String authName;

    @Override
    public String toString() {
        return "MembershipInfoDto{" +
                "userId='" + userId + '\'' +
                ", studyId=" + studyId +
                ", studyName='" + studyName + '\'' +
                ", authName='" + authName + '\'' +
                '}';
    }
}

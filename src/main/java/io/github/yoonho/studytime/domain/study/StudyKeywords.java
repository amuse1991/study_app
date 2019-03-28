package io.github.yoonho.studytime.domain.study;

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
@Table(name = "study_keywords")
public class StudyKeywords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long keywordId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "study_Id")
    private Long studyId;

    @Builder
    public StudyKeywords(String name, Long studyId){
        this.name = name;
        this.studyId = studyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyId(Long studyId) {
        this.studyId = studyId;
    }

    @Override
    public String toString() {
        return "StudyKeywords{" +
                "keywordId=" + keywordId +
                ", name='" + name + '\'' +
                ", studyId=" + studyId +
                '}';
    }
}

package io.github.yoonho.studytime.domain.study;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyKeywordsRepository extends JpaRepository<StudyKeywords,Long> {
    List<StudyKeywords> findAllByStudyId(Long studyId);
}

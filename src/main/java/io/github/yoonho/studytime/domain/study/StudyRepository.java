package io.github.yoonho.studytime.domain.study;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study,Long> {
    List<Study> findByName(String name);
}

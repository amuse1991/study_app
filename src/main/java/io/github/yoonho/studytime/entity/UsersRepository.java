package io.github.yoonho.studytime.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    //JpaRepository<Entity클래스,PK타입>
    //기본적인 CRUD 메소드 자동 생성
}

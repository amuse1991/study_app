package io.github.yoonho.studytime.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// 인터페이스를 정의하면 실행 시점에 spring data jpa가 구현 객체를 동적으로 생성해 주입
public interface UsersRepository extends JpaRepository<Users,Long> {
    //JpaRepository<Entity클래스,PK타입>
    //기본적인 CRUD 메소드 자동 생성

    boolean existsByUserId(String userId);
    void deleteUsersByUserId(String userId);
    Users findUsersByUserId(String userId);
}

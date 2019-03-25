package io.github.yoonho.studytime.domain.membership;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberAuthRepository extends JpaRepository<MemberAuth,Long> {
    MemberAuth findByName(String authName);
    boolean existsByName(String authName);
    //TODO : 테스트할것!
    @Query(value = "SELECT * FROM member_auth auth " +
            "WHERE auth.auth_id = " +
            "(SELECT m.auth_id FROM membership m WHERE m.user_key = :userKey)",nativeQuery = true)
    MemberAuth getMemberAuthByUserKey(@Param("userKey") Long userKey);
}

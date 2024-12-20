package com.example.jpql.repository;

import com.example.jpql.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // 단일 조건
    List<User> findByName(String name);

    // AND 조건
    List<User> findByNameAndAge(String name, int age);

    // OR 조건
    List<User> findByNameOrEmail(String name, String email);

    // Between 조건
    List<User> findByAgeBetween(int start, int end);

    // Like 조건
    List<User> findByNameLike(String pattern);

    // 정렬
    List<User> findByNameOrderByAgeAsc(String name);

    // Top n
    List<User> findTop3ByOrderByAgeDesc();

    // Named Query 호출
    User findByEmail(@Param("email") String email);

    // 네이티브 Named Query 호출
    @Query(name = "User.findByNameNative", nativeQuery = true)
    List<User> findByNameNative(@Param("name") String name);
}

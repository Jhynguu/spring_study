package com.example.jpql.service;

import com.example.jpql.dto.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @PersistenceContext
    private EntityManager entityManager;

    // 기본 조회
    public List<Member> findAllMembers() {
        String jpql = "SELECT m FROM Member m";
        return entityManager.createQuery(jpql, Member.class).getResultList();
    }

    // 조건 조회
    public List<Member> findMembersAboveAge(int age) {
        String jpql = "SELECT m FROM Member m WHERE m.age > :age";
        return entityManager.createQuery(jpql, Member.class)
                .setParameter("age", age)
                .getResultList();
    }
}

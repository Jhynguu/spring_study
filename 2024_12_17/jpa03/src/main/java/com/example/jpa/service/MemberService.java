package com.example.jpa.service;

import com.example.jpa.dto.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void demonstrateEntityLifecycle() {
        // 1. 비영속 상태 (Transient)
        Member member = new Member("홍길동", "hong@example.com");
        System.out.println("1. 비영속 상태: " + member);

        // 2. 영속 상태 (Managed)
        entityManager.persist(member);
        System.out.println("2. 영속 상태: ID가 아직 할당되지 않음");

        entityManager.flush();
        System.out.println("영속 상태 이후: ID = " + member.getId());

        // 3. 변경 감지 (Dirty Checking)
        member.setName("강감찬");
        System.out.println("3. 변경 감지: 이름 변경 -> 강감찬");
        entityManager.flush();

        // 4. 준영속 상태 (Detached)
        entityManager.detach(member);
        System.out.println("4. 준영속 상태: 더 이상 변경 감지되지 않음");
        member.setName("이순신"); // 변경하더라도 UPDATE SQL 실행되지 않음
        entityManager.flush(); // SQL 실행 안 됨

        // 5. 삭제 상태 (Removed)
        // 주의: member가 준영속 상태이므로 영속성 컨텍스트에 다시 merge하여야 함
        member = entityManager.merge(member); // 다시 영속 상태로 변환
        entityManager.remove(member); // 삭제 예약
        System.out.println("5. 삭제 상태: DELETE SQL 실행 예정");
        entityManager.flush(); // DELETE SQL 실행

        // 6. 트랜잭션 종료
        System.out.println("6. 트랜잭션 종료: 데이터베이스에 변경 사항 반영 완료");
    }

}

package com.example.hibernate.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Test @Rollback(false)
    void save() {
        Member member = new Member();
        member.setId(1L);
        member.setName("park");
        memberRepository.save(member);
    }

}
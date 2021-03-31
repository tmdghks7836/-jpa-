package jpabook.jpashop.service;

import jpabook.jpashop.entity.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @Rollback(false)
    void join() {

        //given
        Member member = Member.builder().name("kim").build();

        //when
        Long savedId = memberService.join(member);

        //then

        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    void findMembers() {

        //given
        Member member1 = Member.builder().build();
        member1.setName("Kim");
        Member member2 = Member.builder().build();
        member2.setName("Kim");

        memberService.join(member1);
        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }


        //then
        fail("예외가 발생해야 한다.");
    }

    @Test
    void findOne() {
    }
}
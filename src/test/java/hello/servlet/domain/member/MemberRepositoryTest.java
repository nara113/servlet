package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void after() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("user1", 10);

        // when
        Member save = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(save.getId());
        assertThat(findMember).isEqualTo(save);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("user1", 10);
        Member member2 = new Member("user2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> all = memberRepository.findAll();

        // then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member1, member2);
    }

}
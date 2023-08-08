package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){

        //given : ~한게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : ~하게 했을 때\
        memberService.join(member);
        Member findMember = memberService.findMember(2L);

        //then : ~하게 된다
        Assertions.assertThat(member).isEqualTo(findMember); //검증 API
        //조인한것과 찾은것이 똑같으면 넣고 빼는게 되는것 !

    }
}

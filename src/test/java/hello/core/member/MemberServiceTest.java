package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach //테스트가 실행되기 전에 무조건 실행되는것!
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){

        //given : ~한게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : ~하게 했을 때\
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then : ~하게 된다
        Assertions.assertThat(member).isEqualTo(findMember); //검증 API
        //조인한것과 찾은것이 똑같으면 넣고 빼는게 되는것 !

    }
}

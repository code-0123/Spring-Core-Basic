package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach //테스트가 실행되기 전에 무조건 실행되는것!
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


/*    @Test
    void fieldInjection(){
        OrderServiceImpl orderService = new OrderServiceImpl();

        //Reposiotry를 내가 원하는걸 넣어서 바꾸고 싶다면? (->못함. 방법이 아예 없음)

        //하려면 결국 OrderServiceImpl에서 setter를 또 따로 만들어줘야 한다
        orderService.setMemberRepository(new MemoryMemberRepository());
        orderService.setDiscountPolicy(new FixDiscountPolicy());

        orderService.createOrder(1L, "itemA", 10000); //널포인트익셉션 뜬다
    }*/
}

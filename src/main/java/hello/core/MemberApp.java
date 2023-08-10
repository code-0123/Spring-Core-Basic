package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링은 모든 것이 ApplicationContext에서 시작한다
        //ApplicationContext가 스프링 컨테이너라고 보면 되는데 이게 모든 객체들을 다 관리해준다
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class); //AppConfig에 있는 환경설정 정보를 가지고 스프링이 AppConfig안의 @Bean 붙은 것들을 다 스프링컨테이너에 집어넣어서 관리해준다

        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class); // 이름(memberService)과 반환타입(MemberService) / 이름은 기본적으로 메서드 이름으로 등록된다

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}

package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
public class MemberServiceImpl implements MemberService{

    //가입하고 회원을 찾으려면 앞에서 만들었던 MemberRepository가 필요하다
    //널포인트익셉션이 생기지 않도록 구현객체를 선택해줘야 한다
    private final MemberRepository memberRepository;


    /*
    AutoAppConfig에 아무것도 없는데 @Component으로 인해
    MemberServiceImpl이 그냥 스프링 빈으로 등록이 되어버린다

    public MemberServiceImpl(MemberRepository memberRepository) {
    여기서 의존관계 주입해줄 수 있는 방법이 없다
    그래서 자동의존관계 주입이 필요하다
    의존관계를 자동으로 주입해주는 @Autowired를 생성자에 붙여주면 스프링이
    MemberRepository타입에 맞는 것을 찾아와서 의존관계 주입을 자동으로 연결해서 해준다

    그래서 @Component를 쓰면 @Autowired도 쓰게 된다
    (@Component를 쓰게 되면 빈이 자동으로 등록이 되는데 의존관계를 설정할 수 있는 방법이 없다
    수동으로 등록할 수 있는 장소가 없기 때문이다)
     */
    @Autowired //ac.getBean(MemberRepository.class) 코드가 자동으로 들어가는 것처럼 작동한다
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}

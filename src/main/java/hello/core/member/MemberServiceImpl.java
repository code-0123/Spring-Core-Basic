package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //가입하고 회원을 찾으려면 앞에서 만들었던 MemberRepository가 필요하다
    //널포인트익셉션이 생기지 않도록 구현객체를 선택해줘야 한다
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

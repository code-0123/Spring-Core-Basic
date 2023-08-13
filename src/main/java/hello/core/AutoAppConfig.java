package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  //@Component 붙은 클래스를 찾아서 다 자동으로 스프링 빈으로 등록해줌
        basePackages = "hello.core", // hello.core이 위치에서부터 시작해서 하위 패키지를 찾아간다
        basePackageClasses = AutoAppConfig.class,

        //탐색위치를 지정하지 않으면? @ComponentScan이 붙은 클래스가 디폴트
        //지금 이 코드 기준으로는, hello.core 패키지에서부터 시작해서 그 패키지를 포함하여 하위패키지까지 다 찾는다

        excludeFilters =  @ComponentScan.Filter(type =  FilterType.ANNOTATION, classes = Configuration.class)
        //그중에서 뺄 것들을 지정 (Configuration 어노테이션이 붙은 것들은 빼겠다!)
        //Configuration를 빼놓는 이유는 AppConfig클래스 때문임
        //AppConfig는 수동으로 등록하는건데 저것까지 포함되면 충돌이 생긴다
        //그냥 예제를 안전하게 유지하기 위해 빼둔것
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

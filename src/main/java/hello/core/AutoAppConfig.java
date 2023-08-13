package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  //@Component 붙은 클래스를 찾아서 다 자동으로 스프링 빈으로 등록해줌
        excludeFilters =  @ComponentScan.Filter(type =  FilterType.ANNOTATION, classes = Configuration.class)
        //그중에서 뺄 것들을 지정 (Configuration 어노테이션이 붙은 것들은 빼겠다!)
        //Configuration를 빼놓는 이유는 AppConfig클래스 때문임
        //AppConfig는 수동으로 등록하는건데 저것까지 포함되면 충돌이 생긴다
        //그냥 예제를 안전하게 유지하기 위해 빼둔것
)
public class AutoAppConfig {



}

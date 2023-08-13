package hello.core.scan.filter;

import java.lang.annotation.*;

//아래의 3가지 annotation은 public @interface Component 여기서 가져왔음
@Target(ElementType.TYPE) //TYPE은 클래스 레벨에 붙는다
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}

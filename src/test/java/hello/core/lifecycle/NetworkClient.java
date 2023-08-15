package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    //url은 외부에서 setter로 넣을 수 있도록 한다
    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url); //실제 네트워크가 붙는건 아니고 connect를 통해 이 url이 붙는다는 의미
    }

    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disConnect(){
        System.out.println("close : " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception { //의존관계 주입이 끝나면 호출해주겠다
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disConnect();
    }
}

package hello.core.singleton;

public class SingletonService {

    //자기자신(SingletonService)을 내부에 선언
    //static으로 가지고 있다->클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 된다
    /*
  JVM 자바가 뜰 때 바로 싱글톤 static영역에 오른쪽으로 new라고 하면
  본인이 내부적으로 실행해서 자기자신의 객체를 생성한 후에 인스턴스에 참조를 넣어둔다
  자기자신의 객체 인스턴스를 딱 하나 생성해서 들어있는 것
    */
    private static final SingletonService instance =  new SingletonService();

    public static SingletonService getInstance(){

        return instance;
    }

    private SingletonService(){
        //private 생성자로 생성을 막아버린다
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

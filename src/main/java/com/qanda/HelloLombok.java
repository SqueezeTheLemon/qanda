package com.qanda;
import lombok.Getter; // 따로 생성자와 getter setter를 안 만들어도 알아서 만들어주는 에너테이션
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@RequiredArgsConstructor // 속성을 필요로 하는 생성자가 롬복에 이해 자동으로 생성된다.
public class HelloLombok {
    private final String hello;
    private final int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("hello", 123);

        System.out.println(helloLombok.hello);
        System.out.println(helloLombok.lombok);

    }

}

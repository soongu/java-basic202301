package org.example.java8.lambda;


@FunctionalInterface // 람다를 사용할 수 있는 인터페이스인지 검증
public interface ApplePredicate {

    // 사과를 주고 필터조건을 오버라이딩하면 참, 거짓을 반환
    boolean test(Apple apple);


}

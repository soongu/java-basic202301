package org.example.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import static org.example.java8.lambda.Color.*;
import static org.example.java8.lambda.FilteringApple.*;

public class Main {

    // 무게가 100그램 이하인 사과 필터조건 클래스
    public static class LightApplePredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() <= 100;
        }
    }


    public static void main(String[] args) {

        // 사과바구니 생성
        List<Apple> appleList = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        List<Apple> greenApples
                = filterGreenApples(appleList);

        System.out.println("===== 녹색 사과 필터링 =====");
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        System.out.println("===== 원하는 색 사과 필터링 =====");
        List<Apple> wantedColorApples = filterApplesByColor(appleList, RED);
        for (Apple wantedColorApple : wantedColorApples) {
            System.out.println(wantedColorApple);
        }

        System.out.println("====== 원하는 조건으로 필터링 ======");
        // 노랑 사과만 필터링
        List<Apple> yellowApples = filterApples(appleList, new YellowApplePredicate());
        for (Apple yellowApple : yellowApples) {
            System.out.println(yellowApple);
        }

        System.out.println("==================================");
        // 무게가 100그램 이하인 사과만 필터링 (내부 클래스)
        List<Apple> lightApples = filterApples(appleList, new LightApplePredicate());
        for (Apple lightApple : lightApples) {
            System.out.println(lightApple);
        }
        System.out.println("==================================");
        // 무게가 100그램보다 큰 사과만 필터링 (익명 클래스)
        List<Apple> heavyApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100;
            }
        });

        for (Apple heavyApple : heavyApples) {
            System.out.println(heavyApple);
        }
        System.out.println("==================================");

        // 녹색 사과만 필터링 - 람다 사용
        // 람다 사용 전제 조건: 인터페이스의 추상메서드가 단 하나일 것!
        // 람다가 오버라이딩하는 메서드가 단 한 줄일 경우 중괄호 생략가능
        // 그 한 줄이 리턴문이라면 return키워드 생략가능
        // 파라미터가 단 한개라면 소괄호 생략가능
        List<Apple> greenAppleList = filterApples(appleList, a -> a.getColor() == GREEN);

        // 빨간색 사과면서 100그램 이상인 사과만 필터링
        filterApples(appleList, apple -> {
            System.out.println("사과 필터링한다!!!");
            return apple.getColor() == RED && apple.getWeight() >= 100;
        });


        System.out.println("======= 제네릭 필터 메서드 =======");
        filter(appleList, a -> a.getColor() == RED); // 빨간 사과만 필터링

        List<Integer> numbers = List.of(
            1,2,3,4,5,6,7,8,9,10
        );

        // 짝수만 필터링
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);

        System.out.println("======================================");

        // 사과 리스트에서 사과의 색상만 추출하여 새로운 색상리스트를 반환
        List<Color> colorList = map(appleList, Apple::getColor);
        System.out.println("colorList = " + colorList);

        List<Integer> weightList = map(appleList, Apple::getWeight);
        System.out.println("weightList = " + weightList);

        List<AppleInfo> appleInfos
                = map(appleList, AppleInfo::new);

        System.out.println("appleInfos = " + appleInfos);

        // 전체 사과색변경
        List<Apple> yellows = map(appleList, a -> {
            a.setColor(YELLOW);
            return a;
        });
        for (Apple yellow : yellows) {
            System.out.println(yellow);
        }
    }

    // 사과에서 필요한 데이터 몇개만 추출
    @Getter @NoArgsConstructor
    @ToString @AllArgsConstructor
    public static class AppleInfo {
        private Color color;
        private int weight;

        public AppleInfo(Apple a) {
            this.color = a.getColor();
            this.weight = a.getWeight();
        }

//        public AppleInfo(Color color, int weight) {
//            this.color = color;
//            this.weight = weight;
//        }
    }

}








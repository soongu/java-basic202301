package org.example.java8.stream;

import java.util.List;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;
import static org.example.java8.stream.Dish.Type;
import static org.example.java8.stream.Dish.menu;

public class Filtering {

    public static void main(String[] args) {

        // stream의 filter : 리턴조건에 맞는 데이터만 필터링
        // 요리 목록중에 채식주의자가 먹을 수 있는 음식만 필터링해주세요
        List<Dish> vegeterianDishes = menu.stream()
                .filter(Dish::isVegeterian)
                .collect(toList());

//        for (Dish vegeterianDish : vegeterianDishes) {
//            System.out.println(vegeterianDish);
//        }

        vegeterianDishes.forEach(out::println);

        out.println("=========================================");
        // 요리 목록 중에 육류이면서 600칼로리 미만인 요리만 필터링해서 출력
        menu.stream()
                .filter(dish -> dish.getType() == Type.MEAT && dish.getCalories() < 600)
                .collect(toList())
                .forEach(out::println);


        out.println("=========================================");
        // 필터링 된 요소 중복 제거
        List<Integer> nums = List.of(1, 2, 1, 3, 3, 2, 4, 4, 5, 6);

        // nums 리스트에서 짝수만 필터링한 후 중복을 제거해주세요.
        nums.stream()
                .filter(n -> n % 2 == 0)
                .distinct()  // 중복 제거
                .collect(toList())
                .forEach(out::println);


        out.println("=========================================");
        // 원하는 개수만 필터링하기
        // 칼로리가 300칼로리보다 큰 요리중에 처음 발견된 3개만 필터링
        menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3) // 앞에서부터 3개만 추출
                .collect(toList())
                .forEach(out::println);

        out.println("=========================================");
        // 요소 생략해서 필터링
        // 칼로리가 300칼로리보다 큰 요리중에 처음 2개는 제끼고 필터링
        menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList())
                .forEach(out::println);

        out.println("=========================================");
        //스트림을 사용해서 처음 등장하는 고기 요리 2개를 필터링하세요.
        List<Dish> dishes = menu.stream()
                .filter(m -> m.getType() == Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println("dishes = " + dishes);

    }
}








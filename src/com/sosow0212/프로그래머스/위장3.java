package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 위장3 {
    static public int solution(String[][] clothes) {
        int answer = 1;

        Set<String[]> clothesSet = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 중복 제거
        for(String[] cloth : clothes) {
            clothesSet.add(cloth);
        }

        // 맵에 넣기
        for(String[] cloth : clothesSet) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        // 계산하기
        Iterator<Integer> it = hashMap.values().iterator();
        while (it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes)); // 5

        String[][] clothes2 = {{"cr", "face"}, {"bl", "face"}, {"gr", "face"}};
        System.out.println(solution(clothes2));

    }
}

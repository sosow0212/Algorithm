package com.sosow0212.with_ure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 의상 {

    public static int solution(String[][] clothes) {
        int answer = 1;

        Set<String[]> clothesSet = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 중복 제거
        for (String[] cloth : clothes) {
            clothesSet.add(cloth);
        }

        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);

        }

        Iterator<Integer> it = hashMap.values().iterator();
        while (it.hasNext()) {
            answer *= it.next() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(clothes)); // 5
    }
}

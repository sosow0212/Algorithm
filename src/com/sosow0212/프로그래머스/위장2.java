package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Iterator;

class 위장2 {
    public int solution(String[][] clothes) {
        int ans = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] str : clothes) {
            String type = str[1];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> it = hashMap.values().iterator();
        while (it.hasNext()) {
            ans *= it.next().intValue() + 1;
        }

        return ans - 1;
    }

    public static void main(String[] args) {
        위장2 sol = new 위장2();

        String[][] clothes =
                {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }
}

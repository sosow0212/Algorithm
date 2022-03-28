package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Iterator;

class 위장 {
    public int solution(String[][] clothes) {
        // 1. 옷의 종류 별로 Hashmap에 넣는다.
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String [] str : clothes) {
            String type = str[1];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
        }

        // 입지 않을 때(none)를 생각해서 부위별로 +1씩 더해줘서 경우의 수를 구해준다
        Iterator<Integer> it = hashMap.values().iterator();
        int answer = 1;
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        // 모든 부위가 none인 경우를 빼서 return 해준다.
        return answer - 1;
    }

    public static void main(String[] args) {
        위장 sol = new 위장();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }
}
package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 귤고르기 {
    static public int solution(int k, int[] tangerines) {
        int answer = 0;

        // 1. 필요한 자료구조 선언
        HashMap<Integer, Integer> countOfSize = new HashMap<>();
        List<Integer> keys;

        // 2. HashMap에 사이즈 별 귤의 개수를 넣음
        for (int tangerine : tangerines) {
            countOfSize.put(tangerine, countOfSize.getOrDefault(tangerine, 0) + 1);
        }

        // 3. HashMap의 Value(귤의 개수)를 기준으로 키 값을 내림차순 정렬
        keys = new ArrayList<>(countOfSize.keySet());
        keys.sort(((o1, o2) -> countOfSize.get(o2) - countOfSize.get(o1)));

        // 4. 정답 도출
        int i = 0;
        while (true) {
            if (k <= 0) {
                break;
            }
            k -= countOfSize.get(keys.get(i));
            i++;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 3
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 2
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); // 1
    }
}

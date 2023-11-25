package com.sosow0212.exam.exam1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1 {

    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int[] arr : v) {
            xMap.put(arr[0], xMap.getOrDefault(arr[0], 0) + 1);
            yMap.put(arr[1], yMap.getOrDefault(arr[1], 0) + 1);
        }

        for (Integer key : xMap.keySet()) {
            if (xMap.get(key) == 1) {
                answer[0] = key;
            }
        }

        for (Integer key : yMap.keySet()) {
            if (yMap.get(key) == 1) {
                answer[1] = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        q1 sol = new q1();

        int[][] v = {{1, 4}, {3, 4}, {3, 10}};

        // [1, 10]
        System.out.println(Arrays.toString(sol.solution(v)));
    }
}

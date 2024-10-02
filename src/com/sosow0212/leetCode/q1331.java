package com.sosow0212.leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class q1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] copy = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        Arrays.sort(copy);

        int before = 1;
        for (int i = 0; i < copy.length; i++) {
            if (map.containsKey(copy[i])) {
                continue;
            }

            map.put(copy[i], before);
            before++;
        }

        int[] answer = new int[copy.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        q1331 sol = new q1331();

        // 1, 1, 1
        System.out.println(Arrays.toString(sol.arrayRankTransform(new int[]{100, 100, 100})));
    }
}

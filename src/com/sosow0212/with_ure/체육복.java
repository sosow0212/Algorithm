package com.sosow0212.with_ure;

import java.util.Arrays;

public class 체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] check = new boolean[n];

        Arrays.fill(check, true);
        for (int i : lost) {
            int index = i - 1;
            check[index] = false;
        }

        for (int i = 0; i < reserve.length; i++) {
            int index = reserve[i] - 1;
            if (index < n - 1 && !check[index + 1]) {
                check[index + 1] = true;
            } else if (!check[index]) {
                check[index] = true;
            } else if (index >= 1 && !check[index - 1]) {
                check[index - 1] = true;
            }
        }

        for (boolean b : check) {
            if (b) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//         5
        System.out.println(solution(
                5,
                new int[]{2, 4},
                new int[]{1, 3, 5})
        );

//        // 4
//        System.out.println(solution(
//                5,
//                new int[]{4, 5},
//                new int[]{3, 4})
//        );

//         2
        System.out.println(solution(
                3,
                new int[]{3},
                new int[]{1})
        );
    }
}

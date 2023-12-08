package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 양궁대회 {

    static int max;
    static int[] answer;

    public static int[] solution(int n, int[] info) {
        max = -1;
        answer = new int[info.length];

        permutation(n, info, new int[info.length]);

        if (max == -1) {
            return new int[]{-1};
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    static void permutation(int n, int[] info, int[] lions) {
        if (n == 0) {
            int lionScore = 0;
            int apScore = 0;

            for (int i = 0; i < info.length; i++) {
                if (lions[i] == 0 && info[i] == 0) {
                    continue;
                }

                if (info[i] >= lions[i]) {
                    apScore += (10 - i);
                } else {
                    lionScore += (10 - i);
                }
            }

            if (lionScore > apScore && lionScore - apScore >= max) {
                max = lionScore - apScore;
                answer = lions.clone();
            }

            return;
        }

        for (int i = 0; i < info.length; i++) {
            if (lions[i] > info[i]) {
                break;
            }

            lions[i]++;
            permutation(n - 1, info, lions);
            lions[i]--;
        }
    }

    public static void main(String[] args) {
        // [0,2,2,0,1,0,0,0,0,0,0]
        System.out.println(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));

        // 1 1 1 1 1 1 1 1 0 0 2
        System.out.println(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}));
    }
}

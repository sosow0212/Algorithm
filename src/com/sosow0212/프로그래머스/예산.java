package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;

        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) {
                break;
            } else {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        예산 sol = new 예산();
        int[] d = {2, 2, 3, 3};
        int budget = 10;
        System.out.println(sol.solution(d, budget));
    }
}

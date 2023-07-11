package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 요격시스템 {

    public int solution(int[][] targets) {
        int answer = 0;
        int before = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= before) {
                answer++;
                before = targets[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        요격시스템 sol = new 요격시스템();

        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.println(sol.solution(targets));
    }
}

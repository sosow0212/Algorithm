package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 단속카메라_2 {

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int answer = 0;
        int before = routes[0][1];

        for (int i = 0; i < routes.length; i++) {
            if (before < routes[i][0]) {
                answer++;
                before = routes[i][1];
            }
        }

        System.out.println(Arrays.deepToString(routes));
        return answer + 1;
    }

    public static void main(String[] args) {
        단속카메라_2 sol = new 단속카메라_2();

        // 2
        System.out.println(sol.solution(new int[][]
                {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}
        ));
    }
}

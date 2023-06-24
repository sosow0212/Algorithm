package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 단속카메라 {

    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int endPoint = routes[0][1];

        for (int i = 1; i < routes.length; i++) {

            if (routes[i][0] > endPoint) {
                answer++;
                endPoint = routes[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        단속카메라 sol = new 단속카메라();

        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(sol.solution(routes));
    }
}

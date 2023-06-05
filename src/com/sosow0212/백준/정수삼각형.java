package com.sosow0212.백준;

public class 정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }


        for (int i = 2; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
//
//        for (int i = 0; i < triangle.length; i++) {
//            for (int j = 0; j < triangle[i].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int length = triangle[triangle.length - 1].length;
        for (int i = 0; i < length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        정수삼각형 sol = new 정수삼각형();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        // 30
        System.out.println(sol.solution(triangle));
    }
}

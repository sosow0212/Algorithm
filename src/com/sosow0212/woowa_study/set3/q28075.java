package com.sosow0212.woowa_study.set3;

import java.util.Scanner;

public class q28075 {

    static int n, m;
    static int answer;
    static int[][] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = 0;
        points = new int[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        permutation(0, 0, -1);
        System.out.println(answer);
    }

    private static void permutation(int index, int sum, int beforeCol) {
        if (index == n) {
            if (sum >= m) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int todayPoint = points[i][j];
                if (beforeCol == j) {
                    todayPoint /= 2;
                }
                permutation(index + 1, sum + todayPoint, j);
            }
        }
    }
}

package com.sosow0212.woowacourse_study.week1Test;

import java.util.Scanner;

public class q25602 {

    // 리트코드 q2305 문제와 유사!
    /**
     * 1. 랑에게 캔 하나 주기
     * 2. 랑에게 캔을 줬으면, 그 기준으로 매리 탐색
     * 3. 복구 후 탐색 진행
     */

    static int answer;
    static int n; // 캔의 종류
    static int k; // 날
    static int[] a; // 캔의 종류
    static int[][] r; // 랑 [i번째 날][j번 캔]
    static int[][] m; // 매리

    public static void main(String[] args) {
        initData();
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int sumOfRang, int sumOfMerry) {
        if (index == k) {
            answer = Math.max(answer, sumOfRang + sumOfMerry);
            return;
        }

        // 탐색
        for (int i = 0; i < n; i++) {
            // 캔이 없으면 스킵
            if (a[i] <= 0) {
                continue;
            }

            // 랑 계산을 위해 캔 감소
            a[i]--;
            int rangLikes = r[index][i];

            // 랑에게 캔을 준 후 매리 완탐
            for (int j = 0; j < n; j++) {
                // 캔이 없으면 스킵
                if (a[j] <= 0) {
                    continue;
                }

                a[j]--;
                int merryLikes = m[index][j];
                dfs(index + 1, sumOfRang + rangLikes, sumOfMerry + merryLikes);
                a[j]++;
            }

            a[i]++;
        }
    }


    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 캔의 종류
        k = sc.nextInt(); // k일
        answer = 0;

        a = new int[n]; // 캔
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        r = new int[k][n];
        m = new int[k][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }
    }
}

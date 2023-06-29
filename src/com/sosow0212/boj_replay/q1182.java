package com.sosow0212.boj_replay;

import java.util.Scanner;

public class q1182 {

    static int n, s;
    static int[] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        answer = 0;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(s == 0 ? answer - 1 : answer);
    }

    private static void dfs(int index, int sum) {
        if (index == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        dfs(index + 1, sum);
        dfs(index + 1, sum + arr[index]);
    }
}

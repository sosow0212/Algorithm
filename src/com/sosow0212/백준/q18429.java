package com.sosow0212.백준;

import java.util.Scanner;

public class q18429 {

    static int n;
    static int k;
    static int[] arr;
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        answer = 0;
        visited = new boolean[n];

        permutation(0, 500);
        System.out.println(answer);
    }

    static void permutation(int index, int sum) {
        if (sum < 500) {
            return;
        }

        if (index == n) {
            if (sum >= 500) {
                answer++;
            }
        }

        sum -= k;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}

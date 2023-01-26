package com.sosow0212.백준;

import java.util.Scanner;

public class q1182 {
    static int[] arr;
    private static int n, s;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        recursion(0, 0);
        if (s == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }

    }

    private static void recursion(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        recursion(depth + 1, sum + arr[depth]); // 1. 해당 인덱스 더함
        recursion(depth + 1, sum); // 2. 해당 인덱스 더하지않음
    }
}

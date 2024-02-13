package com.sosow0212.백준;

import java.util.Scanner;

public class q11501 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        long maxVal = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            } else {
                answer += maxVal - arr[i];
            }
        }

        System.out.println(answer);
    }
}

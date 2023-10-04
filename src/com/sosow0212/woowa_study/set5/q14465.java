package com.sosow0212.woowa_study.set5;

import java.util.Scanner;

public class q14465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();

        boolean[] arr = new boolean[n + 1];

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < b; i++) {
            arr[sc.nextInt()] = true;
        }

        for (int i = 1; i <= n - k + 1; i++) {
            int temp = 0;

            for (int j = i; j < i + k; j++) {
                if (arr[j] == true) {
                    temp++;
                }
            }

            answer = Math.min(temp, answer);
        }

        System.out.println(answer);
    }
}

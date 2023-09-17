package com.sosow0212.woowa_study.set1;

import java.util.Scanner;

public class q14594 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = false;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j < b; j++) {
                arr[j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!arr[i]) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}

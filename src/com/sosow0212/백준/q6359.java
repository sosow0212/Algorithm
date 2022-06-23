package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q6359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            boolean[] arr = new boolean[n + 1];
            Arrays.fill(arr, false);

            for (int r = 1; r <= n; r++) {
                for (int j = 0; j < arr.length; j++) {
                    if (j % r == 0) {
                        arr[j] = !arr[j];
                    }
                }
            }

            int ans = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j]) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}
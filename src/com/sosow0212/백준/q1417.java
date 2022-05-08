package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q1417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n - 1];
        int ans = 0;
        int dasom = sc.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        if (n == 1) {
            System.out.println("0");
            return;
        }

        while (true) {
            Arrays.sort(arr);
            if (dasom <= arr[n - 2]) {
                // 다솜이가 표가 적다면
                arr[n - 2]--;
                dasom++;
                ans++;
            } else {
                break;
            }
        }

        System.out.println(ans);


    }
}

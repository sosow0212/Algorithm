package com.sosow0212.백준;

import java.util.Scanner;

public class q14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int ans = 0;

        int[] arr = new int[w];

        for (int i = 0; i < w; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < w - 1; i++) {
            int l = 0;
            int r = 0;

            for (int j = 0; j < i; j++) {
                l = Math.max(arr[j], l);
            }

            for (int j = i + 1; j < w; j++) {
                r = Math.max(arr[j], r);
            }

            if (arr[i] < l && arr[i] < r) {
                ans += Math.min(l, r) - arr[i];
            }
        }
        System.out.println(ans);
    }
}

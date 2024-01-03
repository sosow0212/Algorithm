package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q11497 {

    static final Scanner sc = new Scanner(System.in);

    static StringBuilder sb;

    public static void main(String[] args) {
        sb = new StringBuilder();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb.toString());
    }

    static void solve() {
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] pos = new int[n];

        int l = 0;
        int r = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                // 앞
                pos[l] = arr[i];
                l++;
            } else {
                // 뒤
                pos[r] = arr[i];
                r--;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pos.length - 1; i++) {
            max = Math.max(max, Math.abs(pos[i] - pos[i + 1]));
        }

        max = Math.max(max, Math.abs(pos[0] - pos[arr.length - 1]));
        sb.append(max)
                .append("\n");
    }
}

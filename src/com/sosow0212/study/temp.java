package com.sosow0212.study;

import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] dates = new int[n];
            for (int j = 0; j < n; j++) {
                dates[j] = sc.nextInt();
            }
            int maxLength = 0;
            int length = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0 || dates[j] - dates[j - 1] <= p) {
                    length++;
                } else {
                    length = 1;
                }
                maxLength = Math.max(maxLength, length);
            }
            System.out.println("#" + i + " " + maxLength);
        }
        sc.close();
    }
}

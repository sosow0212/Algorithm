package com.sosow0212.study;

import java.util.Scanner;

public class temp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] dates = new int[n];
        for (int j = 0; j < n; j++) {
            dates[j] = sc.nextInt();
        }
        int maxLength = 0;
        int length = 0;
        for (int j = 0; j < n; j++) {
            if (dates[j] - dates[j - length] <= p && p >= 1) {
                length++;
                p --;
            } else {
                length = 1;
            }
            maxLength = Math.max(maxLength, length);
        }
        System.out.println(maxLength + p);
    }

}

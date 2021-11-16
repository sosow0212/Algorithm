package com.sosow0212.백준;

import java.util.Scanner;

public class q1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[10];
        double temp = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 6 || num == 9) {
                num = 6; // 6으로 몰빵
            }
            arr[num]++;
        }
        temp = arr[6];

        if (temp >= 2) {
            temp = Math.round(temp / 2);
        }
        arr[6] = (int) temp;

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, arr[i]);
        }

        System.out.println(ans);
    }
}

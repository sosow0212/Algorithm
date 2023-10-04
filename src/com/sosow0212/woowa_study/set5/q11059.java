package com.sosow0212.woowa_study.set5;

import java.util.Scanner;

public class q11059 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (isCreStr(str.substring(i, j + 1))) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        System.out.println(max);
    }

    private static boolean isCreStr(final String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        int half = str.length() / 2;

        String front = str.substring(0, half);
        String end = str.substring(half);

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < front.length(); i++) {
            num1 += front.charAt(i) - '0';
            num2 += end.charAt(i) - '0';
        }

        return num1 == num2;
    }
}

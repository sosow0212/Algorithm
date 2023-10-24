package com.sosow0212.woowa_study.set9;

import java.util.Scanner;

public class q22351 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int start = s.charAt(0) - '0';
        int end = 0;

        for (int i = start; i <= 999; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);

            if (sb.toString().equals(s)) {
                System.out.println(s + " " + s);
                return;
            }

            for (int j = i + 1; j <= 999; j++) {
                sb.append(j);
                if (sb.toString().equals(s)) {
                    System.out.println(i + " " + j);
                    return;
                }

                if (sb.length() > s.length()) {
                    break;
                }
            }
        }
    }
}

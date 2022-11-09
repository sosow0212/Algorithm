package com.sosow0212.백준;

import java.util.Scanner;

public class q1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        int ans = a.length();

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int tmp = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    tmp++;
                }
            }
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);


    }
}

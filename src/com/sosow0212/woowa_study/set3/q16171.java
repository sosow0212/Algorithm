package com.sosow0212.woowa_study.set3;

import java.util.Scanner;

public class q16171 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String word = sc.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString().contains(word) ? 1 : 0);
    }
}

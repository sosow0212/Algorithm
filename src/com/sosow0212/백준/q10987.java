package com.sosow0212.백준;

import java.util.Scanner;

public class q10987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count ++;
            }
        }

        System.out.println(count);
    }
}

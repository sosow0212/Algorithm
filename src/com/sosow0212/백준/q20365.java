package com.sosow0212.백준;

import java.util.Scanner;

public class q20365 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int countB = 0;
        int countR = 0;
        char before = ' ';

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c != before) {
                if (c == 'B') {
                    countB++;
                } else {
                    countR++;
                }
            }
            before = c;
        }

        int answer = Math.min(countB, countR) + 1;

        System.out.println(answer);
    }
}

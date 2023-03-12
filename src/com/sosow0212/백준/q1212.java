package com.sosow0212.백준;

import java.util.Scanner;

public class q1212 {

    private static final int OCTA_PARSER = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        String str = sc.next();
        StringBuilder sb = new StringBuilder(str).reverse();

        int octa = 1;
        for (int i = 1; i <= sb.length(); i++) {

            int temp = sb.charAt(i - 1) - '0';

            if (i == 1) {
                octa = 1;
                answer += temp * octa;
                continue;
            }

            octa = octa * OCTA_PARSER;
            answer += temp * octa;
        }

        System.out.println(Integer.toBinaryString(answer));
    }
}

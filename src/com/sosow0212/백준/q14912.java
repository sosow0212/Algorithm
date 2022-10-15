package com.sosow0212.백준;

import java.util.Scanner;

public class q14912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) - '0' == d) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

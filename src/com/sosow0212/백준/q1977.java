package com.sosow0212.백준;

import java.util.Scanner;

public class q1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int sum = 0;
        int min = m;

        for (int i = 0; i <= 100; i++) {
            int sq = i * i;
            if (sq >= n && sq <= m) {
                sum += sq;
                if (min >= sq) {
                    min = sq;
                }
            }
        }

        if (sum == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}

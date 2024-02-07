package com.sosow0212.백준;

import java.util.Scanner;

public class q10103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 100;
        int b = 100;

        for (int i = 0; i < n; i++) {
            int aScore = sc.nextInt();
            int bScore = sc.nextInt();

            if (aScore > bScore) {
                b -= aScore;
            } else if (bScore > aScore) {
                a -= bScore;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}

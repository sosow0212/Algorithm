package com.sosow0212.백준;

import java.util.Scanner;

public class q5523 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a > b) {
                scoreA++;
            } else if (a < b) {
                scoreB++;
            }
        }

        System.out.println(scoreA + " " + scoreB);
    }
}

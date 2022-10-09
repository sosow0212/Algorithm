package com.sosow0212.백준;

import java.util.Scanner;

public class q24736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] score = new int[2];
        int[] info = new int[5];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                info[j] = sc.nextInt();
                score[i] = info[0] * 6 + info[1] * 3 + info[2] * 2 + info[3] + info[4] * 2;
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.print(score[i] + " ");
        }
    }
}

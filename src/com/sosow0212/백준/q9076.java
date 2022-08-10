package com.sosow0212.백준;

import java.util.*;

public class q9076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[5];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < score.length; j++) {
                score[j] = sc.nextInt();
            }
            Arrays.sort(score);
            if (score[3] - score[1] >= 4) {
                System.out.println("KIN");
            } else
                System.out.println(score[1] + score[2] + score[3]);
        }
        sc.close();
    }
}
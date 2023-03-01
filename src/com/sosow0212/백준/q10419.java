package com.sosow0212.백준;

import java.util.Scanner;

public class q10419 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int answer = 1;

            while (answer + (answer * answer) <= n) {
                answer++;
            }

            System.out.println(answer - 1);
        }
    }
}

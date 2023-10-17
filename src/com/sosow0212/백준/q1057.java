package com.sosow0212.백준;

import java.util.Scanner;

public class q1057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;

            answer++;
        }

        System.out.println(answer);
    }
}

package com.sosow0212.백준;

import java.util.Scanner;

public class q1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int answer = 1;
            for (int j = 0; j < b; j++) {
                answer = (a * answer) % 10;
            }

            if (answer == 0) {
                answer = 10;
            }
            System.out.println(answer);
        }
    }
}

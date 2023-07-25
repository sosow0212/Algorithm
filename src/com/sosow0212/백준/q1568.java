package com.sosow0212.백준;

import java.util.Scanner;

public class q1568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        int index = 0;
        while (n != 0) {
            index++;

            if (index > n) {
                index = 0;
                continue;
            }

            n -= index;
            answer += 1;
        }

        System.out.println(answer);
    }
}

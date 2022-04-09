package com.sosow0212.백준;

import java.util.Scanner;

public class q4948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;

            boolean arr[] = new boolean[2 * n + 1];
            arr[0] = true;
            arr[1] = true;

            for (int i = 2; i <= Math.sqrt(2 * n + 1); i++) {
                for (int j = i * i; j < 2 * n + 1; j += i) {
                    arr[j] = true;
                }
            }

            int count = 0;
            for (int i = n + 1; i < 2 * n + 1; i++) {
                if (arr[i] == false) {
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}

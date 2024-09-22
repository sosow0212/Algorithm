package com.sosow0212.백준;

import java.util.Scanner;

public class q2885 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int k = 1;
        int count = 0;

        while (k < n) {
            k *= 2;
        }

        System.out.print(k + " ");

        while (n > 0) {
            if (n >= k) {
                n -= k;
            } else {
                k /= 2;
                count++;
            }
        }

        System.out.println(count);
    }
}

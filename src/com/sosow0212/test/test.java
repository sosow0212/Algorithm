package com.sosow0212.test;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // i = 1,2,3,4,5 (i=1, i<=n)
        // i = 0,1,2,3,4 (i=0; i<n)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
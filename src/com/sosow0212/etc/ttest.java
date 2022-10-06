package com.sosow0212.etc;

import java.util.Scanner;

public class ttest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            double B = sc.nextDouble();
            double N = sc.nextDouble();

            if (B == 0 && N == 0) {
                return;
            }

            int A = 1;
            while ((int) Math.abs((B - (int) Math.pow(A, N))) > (int) Math.abs(B - (int) Math.pow(A + 1, N))) {
                A++;
            }
            System.out.println(A);
        }
    }
}
package com.sosow0212.백준;

import java.util.Scanner;

public class q1735 {
    public static void main(String[] args) {
        int[] num = new int[4];
        int gcd;
        int deno, nume;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        deno = num[0] * num[3] + num[2] * num[1];
        nume = num[1] * num[3];
        gcd = gcdFunc(deno, nume);
        System.out.println(deno / gcd + " " + nume / gcd);
    }

    public static int gcdFunc(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcdFunc(b, a % b);
    }
}
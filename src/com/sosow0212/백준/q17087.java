package com.sosow0212.백준;

import java.util.Scanner;

public class q17087 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int brotherS = sc.nextInt();
            arr[i] = Math.abs(brotherS - s);
        }

        int gcd = arr[0];

        for (int i = 1; i < arr.length; i++) {
            gcd = getGcd(gcd, arr[i]);
        }

        System.out.println(gcd);
    }

    static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return getGcd(b, a % b);
    }
}

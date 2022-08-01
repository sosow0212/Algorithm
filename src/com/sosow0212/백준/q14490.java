package com.sosow0212.백준;

import java.util.Scanner;

public class q14490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splited = sc.nextLine().split(":");
        int n = toInt(splited[0]);
        int m = toInt(splited[1]);
        int GCD = gcd(Math.max(n, m), Math.min(n, m));

        System.out.println(n / GCD + ":" + m / GCD);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

}

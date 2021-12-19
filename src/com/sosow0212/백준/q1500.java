package com.sosow0212.백준;

import java.util.Scanner;

public class q1500 {

    static long s, k;

    static long multi() {
        long result = 1;
        long multiplier = s / k;
        long cnt = s - (multiplier * k);

        for (int i = 0; i < k - cnt; i++) {
            result *= multiplier;
        }

        for (int i = 0; i < cnt; i++) {
            result *= (multiplier + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.nextLong();
        k = sc.nextLong();
        long ans = multi();
        System.out.println(ans);
    }
}

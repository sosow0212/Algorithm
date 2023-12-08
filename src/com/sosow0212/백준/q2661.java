package com.sosow0212.백준;

import java.util.Scanner;

public class q2661 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        permutation("");
    }

    static void permutation(String str) {
        if (str.length() == n) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(str + i)) {
                permutation(str + i);
            }
        }
    }

    static boolean isGood(String str) {
        // 12312
        int halfLength = str.length() / 2;

        for (int i = 1; i <= halfLength; i++) {
            String a = str.substring(str.length() - (i * 2), str.length() - i);
            String b = str.substring(str.length() - i);

            if (a.equals(b)) {
                return false;
            }
        }

        return true;
    }
}

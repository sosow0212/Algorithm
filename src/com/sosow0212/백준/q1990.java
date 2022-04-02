package com.sosow0212.백준;

import java.util.Scanner;

public class q1990 {

    public static boolean prime[] = new boolean[100000001];

    public static void primeCal(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= m; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static boolean isPal(int num) {
        String number = String.valueOf(num);
        String reverseNumber = "";

        for (int i = number.length() - 1; i >= 0; i--) {
            reverseNumber += number.charAt(i);
        }

        if (reverseNumber.equals(number)) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        primeCal(m);

        for (int i = n; i <= m; i++) {
            if (prime[i] == false && isPal(i) == true) {
                sb.append(i).append("\n");
            }
        }

        sb.append(-1);
        System.out.println(sb);
    }
}

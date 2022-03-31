package com.sosow0212.백준;

import java.util.Scanner;

public class q15965 {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        if(n == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 2; ; i++) {
            if(isPrime(i) == true) {
                count ++;
                if(count == n) {
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}

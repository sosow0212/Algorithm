package com.sosow0212.백준;

import java.util.Scanner;

public class q1747 {

    public static boolean isReverse(int n) {
        String num = Integer.toString(n);
        String reverseNum = "";
        for(int i=num.length()-1; i>=0; i--) {
            reverseNum += num.charAt(i);
        }
        if(num.equals(reverseNum)) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int solve(int n) {
        // 소수인지 확인하고, 팰린드롬 확인하고 리턴하기
        for(int i=n; ; i++) {
            if(isPrime(i) && isReverse(i)) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));

    }
}

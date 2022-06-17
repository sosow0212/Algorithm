package com.sosow0212.백준;

import java.util.Scanner;

public class q24416 {
    static int countA = 0;
    static int countB = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);
        fibonacci(n);
        System.out.println(countA + " " + countB);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            countA ++;
            return 1;
        } else {
            return (fib(n-1) + fib(n-2));
        }
    }

    static int fibonacci(int n) {
        int[] arr = new int[n+1];
        arr[1] = arr[2] = 1;
        for(int i=3; i<=n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            countB ++;
        }
        return arr[n];
    }
}

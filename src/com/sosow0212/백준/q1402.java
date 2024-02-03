package com.sosow0212.백준;

import java.util.Scanner;

public class q1402 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        int a = sc.nextInt();
        int b = sc.nextInt();

//        for (int i = 1; i <= b; i++) {
//            for (int j = 1; j <= b; j++) {
//                if (i + j == b && i * j == a) {
//                    System.out.println("yes");
//                    return;
//                }
//            }
//        }
//
//        System.out.println("no");

        System.out.println("yes");
    }
}

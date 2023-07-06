package com.sosow0212.toss.exam1;

import java.util.Scanner;

public class q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            String s = "*".repeat(i);
            System.out.println(s);
        }
    }
}

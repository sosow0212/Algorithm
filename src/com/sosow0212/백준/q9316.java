package com.sosow0212.백준;

import java.util.Scanner;

public class q9316 {
    private final static String def = "Hello World, Judge ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(def + i + "!");
        }
    }
}

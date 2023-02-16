package com.sosow0212.백준;

import java.util.Scanner;

public class q16561 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 1;
        int count = 2;

        for (int i = 9; i < n; i += 3) {
            sum += count;
            count += 1;
        }

        System.out.println(sum);
    }
}

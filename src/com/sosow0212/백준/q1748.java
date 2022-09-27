package com.sosow0212.백준;

import java.util.Scanner;

public class q1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int cnt = 1;
        int temp = 0;
        int length = 10;
        for (int i = 1; i <= number; i++) {
            if (i == length) {
                cnt++;
                length = length * 10;
            }
            temp = temp + cnt;
        }
        System.out.println(temp);
    }
}

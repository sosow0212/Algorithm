package com.sosow0212.codeUp;

import java.util.Scanner;

public class q3301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;

        while(n != 0) {
            count += n / 50000;
            n %= 50000;

            count += n / 10000;
            n %= 10000;

            count += n / 5000;
            n %= 5000;

            count += n / 1000;
            n %= 1000;

            count += n / 500;
            n %= 500;

            count += n / 100;
            n %= 100;

            count += n / 50;
            n %= 50;

            count += n / 10;
            n %= 10;
        }

        System.out.println(count);
    }
}

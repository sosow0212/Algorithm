package com.sosow0212.selfStudy;

import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        while(true) {
            if(m == 0) {
                break;
            }

            if(n < m) {
                int temp = n;
                n = m;
                m = temp;
            }

            n -= m;
        }

        System.out.println(n);
    }
}

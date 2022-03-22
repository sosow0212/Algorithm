package com.sosow0212.백준;

import java.util.Scanner;

public class q10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int h = sc.nextInt(); // 6
            int w = sc.nextInt(); // 12
            int n = sc.nextInt(); // 10

            int first = (n / h) + 1;
            int last =  n % h;
            if(n % h == 0) {
                first = n/h;
                last = h;
            }

            System.out.println(last*100 + first);
        }
    }
}

package com.sosow0212.백준;

import java.util.Scanner;

public class q16466 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[1000001];
        check[0] = true;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            check[temp] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if(!check[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}

package com.sosow0212.백준;

import java.util.Scanner;

public class q27433 {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n == 0) {
            System.out.println(1);
            return;
        }
        dfs(n, 1);

    }

    private static void dfs(int index, int sum) {
        if(index == 1) {
            System.out.println(sum);
            return;
        }

        dfs(index - 1, sum * index);
    }
}

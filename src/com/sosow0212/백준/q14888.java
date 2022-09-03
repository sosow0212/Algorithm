package com.sosow0212.백준;

import java.util.Scanner;

public class q14888 {
    static int n;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < operator.length; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int val) {
        if (depth == n) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] >= 1) {
                operator[i]--;

                if(i == 0) {
                    dfs(depth + 1, val + arr[depth]);
                } else if(i == 1) {
                    dfs(depth + 1, val - arr[depth]);
                } else if(i == 2) {
                    dfs(depth + 1, val * arr[depth]);
                } else if(i == 3) {
                    dfs(depth + 1, val / arr[depth]);
                }

                operator[i]++;
            }
        }
    }
}

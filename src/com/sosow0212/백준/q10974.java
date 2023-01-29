package com.sosow0212.백준;

import java.util.Scanner;

public class q10974 {
    private static int n;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        recursion(0);
    }

    private static void recursion(int index) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            arr[index] = i + 1;
            visited[i] = true;
            recursion(index + 1);
            visited[i] = false;
        }
    }
}

package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q15657 {
    private static int n, m;
    private static int[] arr, answer;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        answer = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        recursion(0);
    }

    private static void recursion(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (index != 0 && arr[i] < answer[index - 1]) {
                    continue;
                }
                answer[index] = arr[i];
                recursion(index + 1);
            }
        }
    }
}

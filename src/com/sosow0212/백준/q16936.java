package com.sosow0212.백준;

import java.util.Scanner;

public class q16936 {

    static int n;
    static int[] given;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        given = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            given[i] = sc.nextInt();
        }

        // sort

        permutation(0, new int[n]);
    }

    static void permutation(int index, int[] arr) {
        if (index == n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] / 3 == arr[i + 1] || arr[i] * 2 == arr[i + 1]) {
                    sb.append(arr[i] + " ");
                } else {
                    return;
                }
            }
            sb.append(arr[index - 1]);

            System.out.println(sb.toString());
            System.exit(1);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arr[index] = given[i];
            permutation(index + 1, arr.clone());
            arr[index] = -1;
            visited[i] = false;
        }
    }
}

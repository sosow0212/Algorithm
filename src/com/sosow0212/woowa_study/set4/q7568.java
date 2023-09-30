package com.sosow0212.woowa_study.set4;

import java.util.Scanner;

public class q7568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] answer = new int[n];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    answer[j]++;
                }
            }
        }

        for (int i : answer) {
            System.out.print(i + 1 + " ");
        }
    }
}

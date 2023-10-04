package com.sosow0212.woowa_study.set5;

import java.util.Arrays;
import java.util.Scanner;

public class q14469 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, ((o1, o2) -> o1[0] - o2[0]));

        int before = 0;
        for (int i = 0; i < arr.length; i++) {
            if (before < arr[i][0]) {
                before = arr[i][0] + arr[i][1];
            } else {
                before += arr[i][1];
            }
        }

        System.out.println(before);
    }
}

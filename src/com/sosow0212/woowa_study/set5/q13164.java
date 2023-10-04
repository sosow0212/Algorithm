package com.sosow0212.woowa_study.set5;

import java.util.Arrays;
import java.util.Scanner;

public class q13164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        for (int i = 0; i < n - k; i++) {
            answer += diff[i];
        }

        System.out.println(answer);
    }
}

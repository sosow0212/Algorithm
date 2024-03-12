package com.sosow0212.백준;

import java.util.Scanner;

public class q14719_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int[] arr = new int[col];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int[] toRight = new int[col];
        for (int i = 0; i < col; i++) {
            max = Math.max(max, arr[i]);
            toRight[i] = max;
        }

        int[] toLeft = new int[col];
        max = 0;
        for (int i = col - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            toLeft[i] = max;
        }

        int[] maxFills = new int[col];
        for (int i = 0; i < col; i++) {
            maxFills[i] = Math.min(toLeft[i], toRight[i]);
        }

        for (int i = 0; i < col; i++) {
            maxFills[i] -= arr[i];
        }

        int answer = 0;
        for (int maxFill : maxFills) {
            if (maxFill != 0) {
                answer += maxFill;
            }
        }

        System.out.println(answer);
    }
}

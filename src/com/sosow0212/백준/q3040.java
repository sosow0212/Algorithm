package com.sosow0212.백준;

import java.util.Scanner;

public class q3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int fake1 = 0;
        int fake2 = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    fake1 = i;
                    fake2 = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != fake1 && i != fake2) {
                System.out.println(arr[i]);
            }
        }


    }
}

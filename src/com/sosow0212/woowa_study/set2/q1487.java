package com.sosow0212.woowa_study.set2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q1487 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        int target = 0;
        int maxPrice = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int result = o1[0] - o2[0];
                if (result == 0)
                    result = o1[1] - o2[1];

                return result;
            }
        });

        for (int i = 0; i < n; i++) {
            int totalPrice = 0;

            for (int j = i; j < n; j++) {
                int price = arr[i][0] - arr[j][1];

                if (price > 0) {
                    totalPrice += price;
                }
            }

            if (maxPrice < totalPrice) {
                maxPrice = totalPrice;
                target = arr[i][0];
            }
        }

        System.out.println(target);
    }
}

/**
 * 13 12
 * 14 5
 * 16 19
 * 17 1  xx
 * 17 2
 * 19 3
 * 30 10
 * 55 40
 */

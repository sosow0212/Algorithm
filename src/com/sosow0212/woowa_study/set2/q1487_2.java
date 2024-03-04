package com.sosow0212.woowa_study.set2;

import java.util.Arrays;
import java.util.Scanner;

public class q1487_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int maxProfit = 0;
        int sellingPrice = 0;

        for (int i = 0; i < n; i++) {
            int targetPrice = arr[i][0];
            int profitOftargetPrice = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j][0] >= targetPrice && arr[j][1] < targetPrice) {
                    profitOftargetPrice += targetPrice - arr[j][1];
                }
            }

            if (profitOftargetPrice > maxProfit) {
                maxProfit = profitOftargetPrice;
                sellingPrice = targetPrice;
            }
        }

        System.out.println(sellingPrice);
    }
}

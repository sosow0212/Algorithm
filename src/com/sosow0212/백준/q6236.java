package com.sosow0212.백준;

import java.util.Scanner;

public class q6236 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            r += arr[i];
            l = Math.max(l, arr[i]);
        }

        while (l <= r) {
            int mid = (l + r) / 2; // 인출 금액

            int sum = 0;
            int drawCount = 1;
            for (int i = 0; i < n; i++) {
                int money = arr[i];

                if (sum + money <= mid) {
                    sum += money;
                } else {
                    sum = money;
                    drawCount++;
                }
            }

            if (drawCount > m) {
                // 돈을 너무 적게 뽑음
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l);
    }
}

package com.sosow0212.백준;

import java.util.Scanner;

public class q2343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        int l = Integer.MIN_VALUE;
        int r = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            r += arr[i];
            l = Math.max(l, arr[i]);
        }

        while (l <= r) {
            int mid = (l + r) / 2;

            int bluray = 1;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                int video = arr[i];

                if (sum + video <= mid) {
                    sum += video;
                } else {
                    sum = video;
                    bluray++;
                }
            }

            if (bluray <= m) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }
}

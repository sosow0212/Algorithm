package com.sosow0212.백준;

import java.util.Scanner;

public class q2792 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];

        int answer = 0;
        int left = 1;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2; // 한 사람당 가져가는 보석의 수
            int sum = 0; // 가져가는 사람

            for (int i : arr) {
                sum += i / mid;

                if (i % mid != 0) {
                    sum++;
                }
            }

            if (sum > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}

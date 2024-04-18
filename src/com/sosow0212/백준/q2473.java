package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q2473 {

    static long near;
    static long[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        near = Long.MAX_VALUE;
        answer = new long[3];
        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            long target = arr[i];

            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                long sum = arr[l] + arr[r] + target;

                if (Math.abs(sum) < Math.abs(near)) {
                    near = sum;
                    answer = new long[]{target, arr[l], arr[r]};
                }

                if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        Arrays.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (long i : answer) {
            sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }
}

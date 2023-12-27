package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2805_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer = 0;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int l = 0;
        int r = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, arr[i]);
        }

        while (l <= r) {
            int mid = (l + r) / 2;

            long sum = 0;
            for (int i : arr) {
                if (i > mid) {
                    sum += (i - mid);
                }
            }

            if (sum >= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
                answer = mid - 1;
            }

        }

        System.out.println(answer);
    }
}

package com.sosow0212.백준;

import java.util.Scanner;

public class q1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int left = 1;
        int right = k;

        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for(int i=1; i<=n; i++) {
                count += Math.min(n, mid/i);
            }

            if(count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}

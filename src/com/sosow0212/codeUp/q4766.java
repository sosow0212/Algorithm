package com.sosow0212.codeUp;

import java.util.Arrays;
import java.util.Scanner;

public class q4766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int low = 0;
        int high = arr[arr.length-1];
        int mid = 0;
        int sum;
        int ans = 0;

        while(low <= high) {
            mid = (low + high) / 2;
            sum = 0;

            for(int i=0; i<n; i++) {
                if(arr[i] >= mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if(sum > k) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}

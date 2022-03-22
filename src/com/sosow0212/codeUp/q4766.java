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
        Arrays.sort(arr);

        int m = sc.nextInt(); // 총 예산
        // 110 120 140 150 // 130
        // 110 120 130 130 = 490

        int high = arr[n-1];
        int low = 0;
        int mid;
        int result = 0;
        int ans = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            result = 0;

            for(int i=0; i<n; i++) {
                if(arr[i] >= mid) {
                    result += mid;
                } else {
                    result += arr[i];
                }
            }

            if(result > m) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }

        }

        System.out.println(ans);
    }
}

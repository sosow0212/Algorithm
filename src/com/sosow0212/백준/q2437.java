package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q2437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        // 1, 1, 2, 3, 6, 7, 30
        // 1 -> 2 -> 3 ->
        int max = 0;
        for(int i=0; i<n; i++) {
            if(max + 1 >= arr[i]) {
                max += arr[i];
            } else {
                break;
            }
        }

        int ans = max + 1;
        System.out.println(ans);


    }
}

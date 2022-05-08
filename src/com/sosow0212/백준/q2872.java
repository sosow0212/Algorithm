package com.sosow0212.백준;

import java.util.*;

public class q2872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = n;
        int maxIndex = -1;
        int len = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == n) {
                maxIndex = i;
            }
        }

        for (int i = maxIndex; i >= 0; i--) {
            if(arr[i] == max - 1) {
                max --;
                len ++;
            }
        }

        System.out.println(n-len);
    }
}

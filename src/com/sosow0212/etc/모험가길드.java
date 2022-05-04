package com.sosow0212.etc;

import java.util.Arrays;
import java.util.Scanner;

public class 모험가길드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        int count = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 1 2 2 2 3

        for (int i = 0; i < n; i++) {
            count += 1;
            if (count >= arr[i]) {
                result += 1;
                count = 0;
            }
        }

        System.out.println(result);
    }
}

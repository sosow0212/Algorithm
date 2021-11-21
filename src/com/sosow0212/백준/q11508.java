package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q11508 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost = 0;
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        // 내림차순 정렬하고 3개씩 묶은 후에,
        // (0, 1, 2x) (3, 4, 5)  즉 i%3 == 2인 인덱스인건 묶음 중 가장 싼 것이므로 건너 뛴다.

        for(int i=0; i<n; i++) {
            if(i%3 == 2) {
                continue;
            }
            cost += arr[i];
        }
        System.out.println(cost);


        // 6 5 5 5 5 4 = 21 (6 5 5) (5 5 4)
    }
}

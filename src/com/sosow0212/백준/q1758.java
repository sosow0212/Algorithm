package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        Long[] arr = new Long[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            Long money = arr[i] - i;
            if(money >+ 0) {
                sum += money;
            }
        }

        System.out.println(sum);
    }
}

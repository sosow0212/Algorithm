package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int sum = 0;
        int temp = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            count ++;
            sum = arr[i] + temp;
            if(count % 2 == 0) {
                temp += sum;
                sum = 0;
            }
        }

        // 10 20 30 40
        // (10+20), (30+30), (40 + 60)

        System.out.println(temp);
    }
}

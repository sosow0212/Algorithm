package com.sosow0212.woowa_study.set8;

import java.util.Scanner;

public class q4929_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }

            int[] arr = new int[a];
            for (int i = 0; i < a; i++) {
                arr[i] = sc.nextInt();
            }

            int b = sc.nextInt();
            int[] arr2 = new int[b];
            for (int i = 0; i < b; i++) {
                arr2[i] = sc.nextInt();
            }

            int answer = 0;
            int arrSum = 0;
            int arr2Sum = 0;
            int i = 0;
            int j = 0;

            while (i < a && j < b) {
                if (arr[i] == arr2[j]) {
                    int crossPoint = arr[i];
                    answer += (Math.max(arrSum, arr2Sum) + crossPoint);
                    arrSum = 0;
                    arr2Sum = 0;
                    i++;
                    j++;
                    continue;
                }

                if (arr[i] < arr2[j]) {
                    arrSum += arr[i];
                    i++;
                    continue;
                }

                if (arr2[j] < arr[i]) {
                    arr2Sum += arr2[j];
                    j++;
                }
            }

            for (; i < a; i++) {
                arrSum += arr[i];
            }

            for (; j < b; j++) {
                arr2Sum += arr2[j];
            }

            answer += Math.max(arrSum, arr2Sum);
            System.out.println(answer);
        }
    }
}

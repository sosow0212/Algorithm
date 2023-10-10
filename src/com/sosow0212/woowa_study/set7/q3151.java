package com.sosow0212.woowa_study.set7;

import java.util.Arrays;
import java.util.Scanner;

public class q3151 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        // -6, -5, -4, -4, 0, 1, 2, 2, 3, 7


        // l, r, 중복 고려
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            int count = 0;

            while (left < right) {
                if (arr[i] + arr[left] + arr[right] == 0) {
                    if (arr[left] == arr[right]) {
                        answer += right - left;
                        count = 0;
                    } else {
                        if (count == 0) {
                            int index = right;
                            while (index > left && arr[i] + arr[left] + arr[index--] == 0) {
                                count++;
                            }
                        }
                        answer += count;
                    }

                    left++;
                } else if (arr[i] + arr[left] + arr[right] < 0) {
                    left++;
                    count = 0;
                } else {
                    right--;
                    count = 0;
                }
            }
        }

        System.out.println(answer);
    }
}

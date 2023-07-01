package com.sosow0212.woowacourse_study.week1Test;

import java.util.Scanner;

public class q14646 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int temp = 0;
        int answer = Integer.MIN_VALUE;

        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < n * 2; i++) {
            int pick = sc.nextInt();

            if (arr[pick] == 0) {
                // 없다면 뽑고 temp++ 최대 개수
                arr[pick]++;
                temp++;
            } else {
                temp--;
            }

            if (temp > answer) {
                // 최대값 갱신
                answer = temp;
            }
        }
        System.out.println(answer);
    }
}

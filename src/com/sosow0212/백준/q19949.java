package com.sosow0212.백준;

import java.util.Scanner;

public class q19949 {

    static int[] exam;
    static int[] arr;
    static int answer;

    public static void main(String[] args) {
        initData();
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int index) {
        if (index == 10) {
            int count = 0;

            for (int i = 0; i < 10; i++) {
                if (exam[i] == arr[i]) {
                    count++;
                }
            }

            if (count >= 5) {
                answer++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (index >= 2 && arr[index - 1] == i && arr[index - 2] == i) {
                continue;
            }

            arr[index] = i;
            dfs(index + 1);
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        arr = new int[10];
        answer = 0;
        exam = new int[10];

        for (int i = 0; i < exam.length; i++) {
            exam[i] = sc.nextInt();
        }
    }
}

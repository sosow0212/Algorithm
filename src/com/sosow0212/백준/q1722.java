package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q1722 {
    private static int n, k;
    private static List<int[]> combination = new ArrayList<>();
    private static int question;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        question = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        if (question == 1) {
            k = sc.nextInt();
            // k번째 순열 구하기
            getCombination(0);
            int[] answer = combination.get(k - 1);
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        int[] answerArr = new int[n];
        for (int i = 0; i < n; i++) {
            answerArr[i] = sc.nextInt();
        }
        getCombination(0);
        int index = 1;
        for (int[] temp : combination) {
            if (Arrays.equals(temp, answerArr)) {
                break;
            }
            index++;
        }
        System.out.println(index);

        return;
    }

    private static void getCombination(int index) {
        if (index == n) {
            combination.add(arr.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[index] = i + 1;
                getCombination(index + 1);
                visited[i] = false;
            }
        }
    }
}

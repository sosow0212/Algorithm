package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q15664 {

    private static final Scanner sc = new Scanner(System.in);
    private static int n, m;
    private static boolean[] visited;
    private static List<int[]> answerList = new ArrayList<>();
    private static int[] givenValues;
    private static int[] answerValues;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        n = sc.nextInt();
        m = sc.nextInt();

        givenValues = new int[n];
        visited = new boolean[n];

        answerValues = new int[m];

        for (int i = 0; i < n; i++) {
            givenValues[i] = sc.nextInt();
        }

        Arrays.sort(givenValues);
    }

    private static void getAnswer() {
        dfs(0);

        for (int[] arr : answerList) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int index) {
        if (index == m) {
            Arrays.sort(answerValues);
            answerList.add(answerValues.clone());
            return;
        }

        for (int i = 0; i < givenValues.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answerValues[index] = givenValues[i];
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
}

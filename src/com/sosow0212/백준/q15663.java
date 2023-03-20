package com.sosow0212.백준;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q15663 {

    static int n, countOfArr;
    static int[] givenArr;
    static int[] answerArr;
    static boolean[] visited;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        countOfArr = sc.nextInt();

        givenArr = new int[n];
        visited = new boolean[n];
        answerArr = new int[countOfArr];

        for (int i = 0; i < n; i++) {
            givenArr[i] = sc.nextInt();
        }

        Arrays.sort(givenArr);
    }

    private static void getAnswer() {
        permutation(0);
    }

    private static void permutation(int index) {
        if (index == countOfArr) {
            StringBuilder sb = new StringBuilder();
            for (int i : answerArr) {
                sb.append(String.valueOf(i) + " ");
            }
            System.out.println(sb);
            return;
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            } else if(temp != givenArr[i]) {
                visited[i] = true;
                answerArr[index] = givenArr[i];
                temp = givenArr[i];
                permutation(index + 1);
                visited[i] = false;
            }
        }
    }
}

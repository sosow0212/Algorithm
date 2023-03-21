package com.sosow0212.백준;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q15664 {

    private static int n, m;
    private static int[] givenArr;
    private static int[] answerArr;
    private static boolean[] visited;
    private static Set<String> answer = new HashSet<>();

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        givenArr = new int[n];
        answerArr = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            givenArr[i] = sc.nextInt();
        }

        Arrays.sort(givenArr);
    }

    private static void getAnswer() {
        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int index) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answerArr.length - 1; i++) {
                if(answerArr[i] <= answerArr[i+1]) {
                    sb.append(String.valueOf(i) + " ");
                }
            }

            if(sb.toString().trim().split(" ").length == m) {
                answer.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < givenArr.length - 1; i++) {
            if (!visited[i]) {
                answerArr[index] = givenArr[i];
                visited[i] = true;
                permutation(index + 1);
                visited[i] = false;
            }
        }
    }
}

package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1965 {
    private static BufferedReader bf;
    private static StringTokenizer st;

    private static int N, result = 0;
    private static int[] nums, dp;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        dp = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) result = Math.max(result, dp[i]);
        System.out.println(result);
    }
}

package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class q17298 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<Integer> reverseAnswer = new ArrayList<>();
        int[] arr = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];

            if (stack.isEmpty()) {
                reverseAnswer.add(-1);
                stack.push(num);
                continue;
            }

            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                reverseAnswer.add(-1);
                stack.push(num);
                continue;
            }

            reverseAnswer.add(stack.peek());
            stack.push(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = reverseAnswer.size() - 1; i >= 0; i--) {
            sb.append(reverseAnswer.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}

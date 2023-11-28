package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q1662 {

    static String str;
    static char[] arr;
    static int[] rightIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        str = sc.next();
        arr = str.toCharArray();
        rightIndex = new int[51];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(i);
            }

            if (c == ')') {
                rightIndex[stack.pop()] = i;
            }
        }

        int answer = permutation(0, str.length());
        System.out.println(answer);
    }

    static int permutation(int start, int end) {
        int length = 0;

        for (int i = start; i < end; i++) {
            if (arr[i] == '(') {
                int pair = rightIndex[i];
                int number = (arr[i - 1] - '0') * permutation(i + 1, pair) - 1;
                length += number;
                i = rightIndex[i];
            } else {
                length++;
            }
        }

        return length;
    }
}

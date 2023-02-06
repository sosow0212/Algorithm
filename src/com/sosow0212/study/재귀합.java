package com.sosow0212.study;

import java.util.ArrayList;
import java.util.List;

public class 재귀합 {
    static int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        recursion(0, 0);
        System.out.println(answer);
    }

    static void recursion(int index, int sum) {
        if (index == arr.length) {
            answer.add(sum);
            return;
        }

        for (int i = 0; i < arr[0].length; i++) {
            recursion(index + 1, sum + arr[index][i]);
        }
    }
}

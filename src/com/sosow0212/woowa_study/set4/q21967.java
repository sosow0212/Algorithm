package com.sosow0212.woowa_study.set4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class q21967 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;
        int[] numbers = new int[11];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            numbers[input]++;
            deque.addLast(input);

            while (getMaxMinDiff(numbers) > 2 && !deque.isEmpty()) {
                int remove = deque.removeFirst();
                numbers[remove]--;
            }
            answer = Math.max(answer, deque.size());
        }

        System.out.println(answer);
    }

    private static int getMaxMinDiff(int[] numbers) {
        int max = 0;

        for (int i = 1; i <= 10; i++) {
            if (numbers[i] > 0) {
                max = i;
                break;
            }
        }

        int min = 0;
        for (int i = 10; i >= 1; i--) {
            if (numbers[i] > 0) {
                min = i;
                break;
            }
        }
        return min - max;
    }
}

package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q16198 {

    static int n;
    static int[] arr;
    static int answer;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        answer = Integer.MIN_VALUE;
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            list.add(arr[i]);
        }

        permutation(list, 0);
        System.out.println(answer);
    }

    static void permutation(List<Integer> balls, int sum) {
        if (balls.size() == 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < balls.size(); i++) {
            if (i == 0 || i == balls.size() - 1) {
                continue;
            }

            sum += (list.get(i - 1) * list.get(i + 1));
            Integer remove = balls.remove(i);

            permutation(balls, sum);

            balls.add(i, remove);
            sum -= (list.get(i - 1) * list.get(i + 1));
        }
    }
}

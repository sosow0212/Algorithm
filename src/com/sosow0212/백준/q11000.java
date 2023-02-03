package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> timeTemp = new PriorityQueue<>();
        int n = sc.nextInt();
        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            int startTimeOfStudy = arr[i][0];
            int endTimeOfStudy = arr[i][1];
            if (!timeTemp.isEmpty() && timeTemp.peek() <= startTimeOfStudy) {
                timeTemp.poll();
            }
            timeTemp.offer(endTimeOfStudy);
        }

        System.out.println(timeTemp.size());
    }
}

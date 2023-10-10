package com.sosow0212.woowa_study.set7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class q1966 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int answer = 0;
        int n = sc.nextInt();
        int target = sc.nextInt();

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            deque.offerLast(new int[]{i, num});
        }

        while (true) {
            int[] poll = deque.pollFirst();
            int nowNum = poll[1];

            boolean isNowNumMaximum = true;
            for (int[] d : deque) {
                if (d[1] > nowNum) {
                    isNowNumMaximum = false;
                    break;
                }
            }

            if (!isNowNumMaximum) {
                deque.offerLast(poll);
                continue;
            }

            answer++;
            if (poll[0] == target) {
                break;
            }
        }

        System.out.println(answer);
    }
}

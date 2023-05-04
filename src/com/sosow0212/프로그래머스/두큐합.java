package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합 {

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        for (int i : queue1) {
            q1.add((long) i);
        }

        for (int i : queue2) {
            q2.add((long) i);
        }

        long sum1 = q1.stream().mapToLong(i -> i).sum();
        long sum2 = q2.stream().mapToLong(i -> i).sum();

        while (sum1 != sum2) {
            answer++;

            if (sum1 > sum2) {
                Long poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.offer(poll);
            } else {
                Long poll = q2.poll();
                sum1 += poll;
                sum2 -= poll;
                q1.add(poll);
            }

            if (answer > (q1.size() + q2.size()) * 2) {
                return -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//         2
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));

//         7
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));

        // -1
        System.out.println(solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}

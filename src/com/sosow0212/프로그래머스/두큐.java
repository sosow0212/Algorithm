package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐 {

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        int limit = 3 * (queue1.length + queue2.length);

        for (Integer i : queue1) {
            q1.add(i);
            sum1 += i;
        }

        for (Integer i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        while (sum1 != sum2) {
            answer++;

            if (sum1 > sum2) {
                Integer poll = q1.poll();
                q2.add(poll);
                sum1 -= poll;
                sum2 += poll;
            } else if (sum2 > sum1) {
                Integer poll = q2.poll();
                q1.add(poll);
                sum1 += poll;
                sum2 -= poll;
            }

            if (answer >= limit) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        // 7
        System.out.println(solution(queue1, queue2));
    }
}

package com.sosow0212.프로그래머스다시;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합 {

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;

        for (int i : queue1) {
            q1.add((long) i);
            q1Sum += i;
        }

        for (int i : queue2) {
            q2.add((long) i);
            q2Sum += i;
        }

        while (q1Sum != q2Sum) {
            answer++;

            if (q1Sum > q2Sum) {
                Long poll = q1.poll();
                q1Sum -= poll;
                q2Sum += poll;
                q2.add(poll);
            } else {
                Long poll = q2.poll();
                q1Sum += poll;
                q2Sum -= poll;
                q1.add(poll);
            }

            if (answer > (q1.size() + q2.size()) * 2) {
                return -1;
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

package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    static public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int q : queue1) 
        {
            q1.offer(q);
            sum1 += q;
        }

        for (int q : queue2) {
            q2.offer(q);
            sum2 += q;
        }

        int count = 0;
        while (sum1 != sum2) {
            count++;

            if (sum1 > sum2) {
                int v = q1.poll();
                q2.offer(v);
                sum1 -= v;
                sum2 += v;
            } else if (sum1 < sum2) {
                int v = q2.poll();
                q1.offer(v);
                sum2 -= v;
                sum1 += v;
            }

            if (count > (queue1.length + queue2.length) * 2) {
                return -1;
            }
        }

        return count;
    }
}

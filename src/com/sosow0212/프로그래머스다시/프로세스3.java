package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스3 {

    public static int solution(int[] priorities, int location) {
        // index, value
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new int[]{i, priorities[i]});
        }

        int order = 0;
        List<int[]> orders = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] now = q.poll();

            if (now[1] == pq.peek()) {
                pq.poll();
                order++;
                orders.add(new int[]{now[0], order});
            } else {
                q.add(now);
            }
        }

        for (int[] ints : orders) {
            if (ints[0] == location) {
                return ints[1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 5
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

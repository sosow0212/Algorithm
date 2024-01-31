package com.sosow0212.프로그래머스다시;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스2 {

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>(); // index, queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            map.put(i, priorities[i]);
            indexQueue.add(i);
        }

        while (!pq.isEmpty()) {
            Integer nowPriority = pq.peek();
            Integer nowIndex = indexQueue.poll();

            if (map.get(nowIndex) == nowPriority) {
                pq.poll();
                answer++;

                if (nowIndex == location) {
                    break;
                }
            } else {
                indexQueue.add(nowIndex);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }
}

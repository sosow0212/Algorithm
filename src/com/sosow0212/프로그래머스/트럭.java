package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

class 트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current_weight = 0;
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (index != truck_weights.length) {
            if (queue.size() == bridge_length) {
                current_weight = queue.poll();
                continue;
            }

            if (current_weight + truck_weights[index] > weight) {
                queue.add(0);
                answer++;
                continue;
            }

            queue.add(truck_weights[index]);
            current_weight += truck_weights[index];
            answer++;
            index++;
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) {
        트럭 sol = new 트럭();

        // 8
        System.out.println(sol.solution(2, 10, new int[]{7, 4, 5, 6}));

        // 101
        System.out.println(sol.solution(100, 100, new int[]{10}));

        // 110
        System.out.println(sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}

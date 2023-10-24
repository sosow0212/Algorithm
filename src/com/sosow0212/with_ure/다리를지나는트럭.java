package com.sosow0212.with_ure;

import java.util.ArrayDeque;
import java.util.Deque;

public class 다리를지나는트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int index = -1;
        int truckTotalWeightInBridge = 0;

        Deque<int[]> trucks = new ArrayDeque<>();

        while (!trucks.isEmpty() && index < truck_weights.length) {
            if (trucks.isEmpty()) {
                index++;
                trucks.add(new int[]{index, 0});
                truckTotalWeightInBridge += truck_weights[index];
                continue;
            }

            if (!trucks.isEmpty() && trucks.peek()[0] + truckTotalWeightInBridge <= weight) {
                index++;
                trucks.add(new int[] {index, 0});
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));

        // 101
        System.out.println(solution(100, 100, new int[]{10}));

        // 110
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}

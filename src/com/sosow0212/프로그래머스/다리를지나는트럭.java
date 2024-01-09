package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucksQueue = new LinkedList<>();
        Queue<Integer> waitTruck = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            trucksQueue.add(0);
        }

        for (int truckWeight : truck_weights) {
            waitTruck.add(truckWeight);
        }

        int time = 0;
        int sum = 0;
        while (!trucksQueue.isEmpty()) {
            sum -= trucksQueue.poll();

            if (waitTruck.isEmpty()) {
                time += bridge_length;
                break;
            }

            if (sum + waitTruck.peek() <= weight) {
                Integer waitTruckWeight = waitTruck.poll();

                trucksQueue.add(waitTruckWeight);
                sum += waitTruckWeight;
            } else {
                trucksQueue.add(0);
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        // 8
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}

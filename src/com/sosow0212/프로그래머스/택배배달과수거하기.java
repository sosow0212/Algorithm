package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 택배배달과수거하기 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 1. 데이터 세팅 (먼 곳부터 탐색해야하므로 역순 저장)
        int sizeOfLastDeliveries = 0;
        int sizeOfLastPickups = 0;

        List<Integer> reverseDeliveries = new ArrayList<>();
        List<Integer> reversePickups = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            reverseDeliveries.add(deliveries[i]);
            reversePickups.add(pickups[i]);
        }

        // 2. 먼곳부터 순차적으로 남은 배달 혹은 픽업 건에 추가
        // 2-1. while -> 남은 배달 혹은 픽업이 0이 될 때까지 빼주고, 거리 * 2
        for (int i = 0; i < n; i++) {
            sizeOfLastDeliveries += reverseDeliveries.get(i);
            sizeOfLastPickups += reversePickups.get(i);

            while (true) {
                if(sizeOfLastDeliveries <= 0 && sizeOfLastPickups <= 0) {
                    break;
                }
                sizeOfLastDeliveries -= cap;
                sizeOfLastPickups -= cap;
                answer += (n - i) * 2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        System.out.println(solution(cap, n, deliveries, pickups)); // 30
    }
}

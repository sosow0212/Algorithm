package com.sosow0212.프로그래머스;

public class 택배배달 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int deliverySize = 0;
        int pickupSize = 0;

        for (int i = deliveries.length - 1; i >= 0; i--) {
            deliverySize += deliveries[i];
            pickupSize += pickups[i];

            while (true) {
                if (deliverySize <= 0 && pickupSize <= 0) {
                    break;
                }

                deliverySize -= cap;
                pickupSize -= cap;

                answer += 2 * (i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 16
        System.out.println(solution(
                4,
                5,
                new int[]{1, 0, 3, 1, 2},
                new int[]{0, 3, 0, 4, 0}
        ));
    }
}

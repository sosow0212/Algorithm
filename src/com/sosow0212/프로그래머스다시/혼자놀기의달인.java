package com.sosow0212.프로그래머스다시;

import java.util.PriorityQueue;

public class 혼자놀기의달인 {

    public static int solution(int[] cards) {
        int answer = 1;

        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < cards.length; i++) {
            int sum = 0;
            int card = cards[i];
            int nextIndex = card - 1;

            if (visited[i]) {
                continue;
            }

            sum += 1;
            visited[i] = true;

            while (!visited[nextIndex]) {
                visited[nextIndex] = true;
                sum += 1;
                nextIndex = cards[nextIndex] - 1;
            }

            pq.add(sum);
        }

        if (pq.size() == 1) {
            return 0;
        }

        while (pq.size() != 2) {
            pq.poll();
        }

        while (!pq.isEmpty()) {
            answer *= pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};

        // 12
        System.out.println(solution(cards));
    }
}

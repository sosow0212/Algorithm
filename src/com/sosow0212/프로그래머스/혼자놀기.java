package com.sosow0212.프로그래머스;

import java.util.PriorityQueue;

public class 혼자놀기 {

    public int solution(int[] cards) {
        int answer = 0;
        PriorityQueue<Integer> temp = new PriorityQueue<>();

        boolean[] visited = new boolean[cards.length];

        for (int i = 0; i < cards.length; i++) {
            int sum = 0;

            if (!visited[i]) {
                visited[i] = true;
            } else {
                continue;
            }

            sum += 1;
            int nextIndex = cards[i] - 1;

            while (true) {
                if (visited[nextIndex]) {
                    break;
                }

                visited[nextIndex] = true;
                sum += 1;
                nextIndex = cards[nextIndex] - 1;
            }

            temp.add(sum);
        }

        if (temp.size() == 1) {
            answer = 0;
        } else {
            answer = 1;
            temp.poll();

            while(temp.size() != 2) {
                temp.poll();
            }

            while (!temp.isEmpty()) {
                answer *= temp.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        혼자놀기 sol = new 혼자놀기();

        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};

        // 12
        System.out.println(sol.solution(cards));

    }
}

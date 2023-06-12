package com.sosow0212.프로그래머스;

import java.util.PriorityQueue;

public class 더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovilleList = new PriorityQueue<>();
        for (int i : scoville) {
            scovilleList.add(i);
        }

        while (true) {
            if (isDone(scovilleList, K)) {
                break;
            }

            if(scovilleList.size() < 2) {
                answer = -1;
                break;
            }

            Integer min = scovilleList.poll();
            Integer nextMin = scovilleList.poll();

            scovilleList.add(min + (nextMin * 2));
            answer++;
        }

        return answer;
    }

    private boolean isDone(final PriorityQueue<Integer> scovilleList, int k) {
        return scovilleList.stream()
                .noneMatch(i -> i < k);
    }

    public static void main(String[] args) {
        더맵게 sol = new 더맵게();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        // 2
        System.out.println(sol.solution(scoville, k));
    }
}

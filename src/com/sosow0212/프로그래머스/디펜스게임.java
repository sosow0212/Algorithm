package com.sosow0212.프로그래머스;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디펜스게임 {

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            if (n < enemy[i] && k == 0) {
                break;
            }

            pq.offer(enemy[i]);
            if (n < enemy[i]) {
                n += pq.poll();
                k--;
            }

            n -= enemy[i];
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}

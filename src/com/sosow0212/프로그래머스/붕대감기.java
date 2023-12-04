package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 붕대감기 {

    public static int solution(int[] bandage, int health, int[][] attacks) {
        Queue<int[]> attackQueue = new LinkedList<>(Arrays.asList(attacks));

        int needTime = bandage[0];
        int healForTime = bandage[1];
        int bonusHeal = bandage[2];

        int nowHealth = health;
        int successCount = 0;
        int time = 0;

        while (!attackQueue.isEmpty() && nowHealth >= 1) {
            time++;

            if (time == attackQueue.peek()[0]) {
                int[] attack = attackQueue.poll();
                nowHealth -= attack[1];
                successCount = 0;
                continue;
            }

            successCount++;
            if (nowHealth != health) {
                nowHealth += healForTime;
            }

            if (needTime == successCount) {
                nowHealth += bonusHeal;
                successCount = 0;
            }

            if (nowHealth >= health) {
                nowHealth = health;
            }
        }

        if (nowHealth <= 0) {
            return -1;
        }

        return nowHealth;
    }

    public static void main(String[] args) {
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};

        // 3
        System.out.println(solution(bandage, health, attacks));
    }
}

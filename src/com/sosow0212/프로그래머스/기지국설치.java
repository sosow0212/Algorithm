package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기지국설치 {

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        List<int[]> sections = new ArrayList<>();

        if (stations[0] - w - 1 >= 1) {
            sections.add(new int[]{1, stations[0] - w - 1});
        }

        for (int i = 0; i < stations.length - 1; i++) {
            int start = stations[i] + w + 1;
            int end = stations[i + 1] - w - 1;

            sections.add(new int[]{start, end});
        }

        if (stations[stations.length - 1] + w + 1 <= n) {
            sections.add(new int[]{stations[stations.length - 1] + w + 1, n});
        }

        for (int[] section : sections) {
            int emptyRange = section[1] - section[0] + 1;

            int range = (2 * w) + 1;
            int count = emptyRange / range;
            if (emptyRange % range >= 1) {
                count++;
            }

            answer += count;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 3
//        System.out.println(solution(11, new int[]{4, 11}, 1));

        // 3
        System.out.println(solution(16, new int[]{9}, 2));
    }
}

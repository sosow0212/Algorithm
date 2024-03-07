package com.sosow0212.프로그래머스;

import java.util.Map;

public class 광물캐기 {

    static final int DIA_INDEX = 0;
    static final int IRON_INDEX = 1;
    static final int STONE_INDEX = 2;

    // [곡괭이][광물]
    static final int[][] NEED_POWER = new int[][]{
            {1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}
    };

    static final Map<String, Integer> mineralMap = Map.of(
            "diamond", DIA_INDEX,
            "iron", IRON_INDEX,
            "stone", STONE_INDEX
    );

    static int answer;

    public static int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        permutation(picks, minerals, 0, 0);
        return answer;
    }

    static void permutation(int[] picks, String[] minerals, int sum, int index) {
        if (index == minerals.length || isDone(picks)) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            int nextSum = sum;
            if (picks[i] == 0) {
                continue;
            }

            // 5개를 캘 수 있으면 해당 인덱스 or 마지막 광물의 인덱스
            int finishIndex = Math.min(index + 5, minerals.length);

            // 이전 인덱스 ~ finishIndex까지 피로도 계산
            for (int j = index; j < finishIndex; j++) {
                nextSum += NEED_POWER[i][mineralMap.get(minerals[j])];
            }

            picks[i]--;
            permutation(picks, minerals, nextSum, finishIndex);
            picks[i]++;
        }
    }

    static boolean isDone(final int[] picks) {
        for (int pick : picks) {
            if (pick != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        // 12
        System.out.println(solution(new int[]{1, 3, 2}, minerals));
    }
}

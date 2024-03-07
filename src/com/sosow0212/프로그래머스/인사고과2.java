package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 인사고과2 {

    static class Score implements Comparable<Score> {

        int pride;
        int peer;

        public Score(final int pride, final int peer) {
            this.pride = pride;
            this.peer = peer;
        }

        @Override
        public int compareTo(final Score o) {
            if (o.pride == this.pride) {
                return this.peer - o.peer;
            }

            return o.pride - this.pride;
        }
        // pride 내림차순 / 같을 시 peer 오름차순

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Score score)) return false;
            return pride == score.pride && peer == score.peer;
        }
    }

    public static int solution(int[][] scores) {
        int answer = 0;

        List<Score> list = new ArrayList<>();

        for (int[] score : scores) {
            list.add(new Score(score[0], score[1]));
        }

        Collections.sort(list);

        int maxPeer = 0;
        Score boundary = new Score(scores[0][0], scores[0][1]);

        for (Score s : list) {
            if (maxPeer > s.peer && (s.equals(boundary))) {
                return -1;
            } else {
                maxPeer = Math.max(maxPeer, s.peer);
                if (boundary.pride + boundary.peer < s.pride + s.peer) {
                    answer += 1;
                }
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};

        // 4
        System.out.println(solution(scores));
    }
}

package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 인사고과 {

    static List<Score> scoreList;

    public static int solution(int[][] scores) {
        int answer = 0;
        scoreList = new ArrayList<>();

        for (int[] score : scores) {
            scoreList.add(new Score(score[0], score[1]));
        }

        Collections.sort(scoreList);

        int maxPeer = 0;
        Score wanho = new Score(scores[0][0], scores[0][1]);

        for (Score s : scoreList) {
            if (maxPeer > s.peer && (s.equals(wanho))) {
                return -1;
            } else {
                maxPeer = Math.max(maxPeer, s.peer);
                if (wanho.attitude + wanho.peer < s.attitude + s.peer) {
                    answer += 1;
                }
            }
        }

        return answer + 1;
    }

    static class Score implements Comparable<Score> {
        int attitude;
        int peer;

        public Score(final int attitude, final int peer) {
            this.attitude = attitude;
            this.peer = peer;
        }

        @Override
        public int compareTo(final Score o) {
            if (this.attitude == o.attitude) {
                return this.peer - o.peer;
            }

            return o.attitude - this.attitude;
        }

        public boolean equals(final Score score) {
            return this.peer == score.peer && this.attitude == score.attitude;
        }
    }


    public static void main(String[] args) {
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};

        // 4
        System.out.println(solution(scores));
    }
}

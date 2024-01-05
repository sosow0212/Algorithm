package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 주사위고르기 {

    static int n;
    static boolean[] visited;
    static List<int[]> diceComb;

    static List<Integer> scoreA;
    static List<Integer> scoreB;

    public static int[] solution(int[][] dice) {
        n = dice.length;
        int[] answer = new int[n / 2];

        visited = new boolean[n];
        diceComb = new ArrayList<>();

        // 1. A가 뽑을 수 있는 주사위 조합 구하기
        permutation(0, 0, new int[n / 2]);

        // 2. 주사위 조합 별로 승률 계산
        int max = Integer.MIN_VALUE;
        for (int[] combA : diceComb) {
            int[] combB = new int[n / 2];
            boolean[] other = new boolean[n];

            int index = 0;
            for (int choice : combA) {
                other[choice] = true;
            }

            for (int i = 0; i < other.length; i++) {
                if (!other[i]) {
                    combB[index] = i;
                    index++;
                }
            }

            scoreA = new ArrayList<>(); // A가 선택한 주사위의 모든 조합
            scoreB = new ArrayList<>(); // B가 선택한 주사위의 모든 조합

            combDice(0, combA, dice, 0, scoreA);
            combDice(0, combB, dice, 0, scoreB);

            Collections.sort(scoreA);
            Collections.sort(scoreB);


            // 3. 이분탐색으로 승리 카운트 찾는다
            int totalWinCount = 0;
            for (Integer a : scoreA) {
                int left = 0;
                int right = scoreB.size();

                while (left + 1 < right) {
                    int mid = (left + right) / 2;

                    if (a > scoreB.get(mid)) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }

                totalWinCount += left;
            }

            if (totalWinCount > max) {
                max = totalWinCount;
                answer = combA;
            }

        }

        int[] answer2 = new int[n / 2];
        if (n == 2) {
            return new int[]{answer[0] + 1};
        } else {
            for (int i = 0; i < answer.length; i++) {
                answer2[i] = answer[i] + 1;
            }
        }

        return answer2;
    }

    static void combDice(int index, int[] dices, int[][] originDices, int sum, List<Integer> team) {
        if (index == dices.length) {
            team.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            combDice(index + 1, dices, originDices, sum + originDices[dices[index]][i], team);
        }
    }

    static void permutation(int depth, int index, int[] arr) {
        if (depth == n / 2) {
            diceComb.add(arr.clone());
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1, i + 1, arr);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};

        // 1 4
        System.out.println(Arrays.toString(solution(dice)));

        // 2
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}})));

//        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 1, 1, 1, 1}, {2, 2, 2, 2, 2, 2}, {3, 3, 3, 3, 3, 3}, {4, 4, 4, 4, 4, 4}, {5, 5, 5, 5, 5, 5}, {6, 6, 6, 6, 6, 6}})));
    }
}

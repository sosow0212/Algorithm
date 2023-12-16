package com.sosow0212.exam.kin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ret 23.12.14
public class q3 {

    static int winCount;
    static List<Integer> result;
    static List<Integer> sum;
    static boolean[] visited;

    public static int[] solution(int[][] dice) {
        visited = new boolean[dice.length];
        winCount = 0;
        result = new ArrayList<>();
        sum = new ArrayList<>();

        permutations(dice, visited, new ArrayList<>(), dice.length / 2, -1);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void permutations(final int[][] dice,
                                     final boolean[] visited,
                                     final List<Integer> now,
                                     final int size,
                                     final int before) {
        if (now.size() == size) {
            calculate(now, dice);
            return;
        }

        for (int i = 0; i < dice.length; i++) {
            if (!visited[i] && before < i) {
                visited[i] = true;
                now.add(i);
                permutations(dice, visited, now, size, i);
                visited[i] = false;
                now.remove(now.size() - 1);
            }
        }
    }

    private static void calculate(final List<Integer> now, final int[][] dice) {
        List<Integer> remain = new ArrayList<>();

        for (int i = 0; i < dice.length; i++) {
            if (!now.contains(i)) {
                remain.add(i);
            }
        }

        sum.clear();
        sum(now, dice, 0, 0);
        List<Integer> first = new ArrayList<>(sum);

        sum.clear();
        sum(remain, dice, 0, 0);
        List<Integer> second = new ArrayList<>(sum);

        updateResult(now, first, second);
    }

    private static void sum(final List<Integer> choose,
                            final int[][] dice,
                            final int index,
                            final int total) {
        if (index >= choose.size()) {
            sum.add(total);
            return;
        }

        for (int i = 0; i < dice[0].length; i++) {
            sum(choose, dice, index + 1, total + dice[choose.get(index)][i]);
        }
    }

    private static void updateResult(final List<Integer> now,
                                     final List<Integer> first,
                                     final List<Integer> second) {
        int win = 0;

        for (Integer f : first) {
            for (Integer s : second) {
                if (f > s) {
                    win++;
                }
            }
        }

        if (winCount < win) {
            winCount = win;
            List<Integer> list = new ArrayList<>();
            now.forEach(i -> list.add(i + 1));
            result = list;
        }
    }

    public static void main(String[] args) {
        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        // 1,4
        System.out.println(Arrays.toString(solution(dice)));
    }
}

package com.sosow0212.프로그래머스.pccp.모의고사1;

public class 체육대회 {

    static int m;
    static int answer;
    static int n;
    static boolean[] visited;

    public int solution(int[][] ability) {
        answer = Integer.MIN_VALUE;
        m = ability[0].length;
        n = ability.length;
        visited = new boolean[n];

        permutation(0, new int[m], ability);
        return answer;
    }

    private void permutation(int index, int[] now, int[][] ability) {
        if (index == m) {
            int sum = 0;
            for (int i : now) {
                sum += i;
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                now[index] = ability[i][index];
                permutation(index + 1, now, ability);
                now[index] = 0;
                visited[i] = false;
            }
        }
    }
}

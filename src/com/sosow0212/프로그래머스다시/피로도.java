package com.sosow0212.프로그래머스다시;

public class 피로도 {

    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0;

        visited = new boolean[dungeons.length];
        permutation(dungeons, 0, k);

        return answer;
    }

    private void permutation(int[][] dungeons, int index, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0] && k >= dungeons[i][1]) {
                visited[i] = true;
                permutation(dungeons, index + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, index);
    }

    public static void main(String[] args) {
        피로도 sol = new 피로도();

        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.println(sol.solution(k, dungeons)); // 3
    }
}

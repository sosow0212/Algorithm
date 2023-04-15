package com.sosow0212.프로그래머스;

class 피로도3 {

    private static int answer;
    private static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[3];
        dfs(0, dungeons, 80);
        return answer;
    }

    private void dfs(int depth, int[][] dungeons, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k && dungeons[i][1] <= k) {
                visited[i] = true;
                dfs(depth + 1, dungeons, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }

    public static void main(String[] args) {
        피로도3 sol = new 피로도3();
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(sol.solution(80, dungeons)); // 3
    }
}

package com.sosow0212.프로그래머스;

public class 땅따먹기 {

    private int col;
    private int row;
    private int[][] land;
    private int answer;

    int solution(int[][] land) {
        answer = 0;

        row = land.length;
        col = land[0].length;
        this.land = land;

        for (int i = 0; i < col; i++) {
            dfs(i, 0, land[0][i]);
        }

        return answer;
    }

    void dfs(int prevIndex, int depth, int sum) {
        if (depth == row) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < col; i++) {
            if (prevIndex == i) {
                continue;
            }

            dfs(i, depth + 1, sum + land[depth][i]);
        }
    }

    public static void main(String[] args) {
        땅따먹기 sol = new 땅따먹기();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        // 16;
        System.out.println(sol.solution(land));
    }
}

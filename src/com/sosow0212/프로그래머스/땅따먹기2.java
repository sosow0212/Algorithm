package com.sosow0212.프로그래머스;

class 땅따먹기2 {

    int solution(int[][] land) {
        int answer = 0;
        int row = land.length;
        int col = land[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < col; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, land[i][j] + land[i - 1][k]);
                }

                land[i][j] = max;
            }
        }

        answer = Integer.MIN_VALUE;
        for(int i=0; i<col; i++) {
            answer = Math.max(answer, land[row - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        땅따먹기2 sol = new 땅따먹기2();

        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        // 16
        System.out.println(sol.solution(land));
    }
}

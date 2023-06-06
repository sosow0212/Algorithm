package com.sosow0212.프로그래머스;

public class 등굣길2 {

    private static final int MOD = 1000000007;
    static int[][] map;
    static int answer;

    public int solution(int m, int n, int[][] puddles) {
        initData(n, m, puddles);
        getAnswer(n, m);
        return answer;
    }

    private void getAnswer(int n, int m) {
        map[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    if (i >= 1 && map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j];
                    }
                    if (j >= 1 && map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1];
                    }
                    if (map[i][j] > 1000000007) {
                        map[i][j] %= 1000000007;
                    }
                }
            }
        }

        answer = map[n - 1][m - 1];
    }

    private void initData(final int n, final int m, final int[][] puddles) {
        answer = 0;
        map = new int[n][m];

        if (puddles[0].length > 0) {
            for (int[] puddle : puddles) {
                map[puddle[1] - 1][puddle[0] - 1] = -1;
            }
        }

    }

    public static void main(String[] args) {
        등굣길2 sol = new 등굣길2();

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        // 4 --> 정답 % 1,000,000,007
        System.out.println(sol.solution(m, n, puddles));
    }
}

package com.sosow0212.프로그래머스;

public class 프렌즈4블록 {
    static public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[m - i - 1].toCharArray();
        }

        while (true) {
            boolean flag = true;
            boolean[][] check = new boolean[m][n];

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '.') {
                        continue;
                    }
                    char c = map[i][j];
                    if (c == map[i][j + 1] && c == map[i + 1][j] && c == map[i + 1][j + 1]) {
                        check[i][j] = true;
                        check[i][j + 1] = true;
                        check[i + 1][j] = true;
                        check[i + 1][j + 1] = true;
                        flag = false;
                    }
                }
            }

            if (flag) {
                break;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.') {
                        for (int k = i; k < m; k++) {
                            if (map[k][j] == '.') {
                                continue;
                            }
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m, n, board));
    }
}

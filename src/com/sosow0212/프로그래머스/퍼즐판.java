package com.sosow0212.프로그래머스;

public class 퍼즐판 {

    static int n;
    static int m;
    static int[] redStart;
    static int[] redEnd;
    static int[] blueStart;
    static int[] blueEnd;
    static boolean[][][] visited;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer;

    public static int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;

        n = maze.length;
        m = maze[0].length;

        initPosition(maze);

        visited = new boolean[n][m][2];
        visited[redStart[0]][redStart[1]][0] = true;
        visited[blueStart[0]][blueStart[1]][0] = true;

        permutation(0, 0, redStart[0], redStart[1], blueStart[0], blueStart[1], maze);

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }

        return answer;
    }

    static void permutation(int index, int turn, int redRow, int redCol, int blueRow, int blueCol, int[][] maze) {
        if (!(redRow >= 0 && redRow < n && redCol >= 0 && redCol < m) ||
                !(blueRow >= 0 && blueRow < n && blueCol >= 0 && blueCol < m)) {
            return;
        }

        if (isSuccessRed(redRow, redCol) && isSuccessBlue(blueRow, blueCol)) {
            if (turn == 1) {
                answer++;
            }

            answer = Math.min(answer, index / 2);
            return;
        }

        if (turn == 0) {
            if (isSuccessRed(redRow, redCol)) {
                permutation(index + 1, 0, redRow, redCol, blueCol, blueRow, maze);
            } else {
                for (int i = 0; i < pos.length; i++) {
                    int nRRow = redRow + pos[i][0];
                    int nRCol = redCol + pos[i][1];

                    if (nRRow >= 0 && nRRow < n && nRCol >= 0 && nRCol < m &&
                            nRRow != blueRow && nRCol != blueCol &&
                            maze[nRRow][nRCol] != 5 &&
                            !visited[nRRow][nRCol][turn]) {
                        visited[nRRow][nRCol][turn] = true;
                        permutation(index + 1, 0, nRRow, nRCol, blueRow, blueCol, maze);
                    }
                }
            }
        } else {
            if (isSuccessBlue(blueRow, blueCol)) {
                permutation(index + 1, 1, redRow, redCol, blueCol, blueRow, maze);
            } else {
                for (int i = 0; i < pos.length; i++) {
                    int nBRow = blueRow + pos[i][0];
                    int nBCol = blueCol + pos[i][1];

                    if (nBRow >= 0 && nBRow < n && nBCol >= 0 && nBCol < m &&
                            nBRow != redRow && nBCol != redCol &&
                            maze[nBRow][nBCol] != 5 &&
                            !visited[nBRow][nBCol][turn]) {
                        visited[nBRow][nBCol][turn] = true;
                        permutation(index + 1, 1, nBRow, nBCol, blueRow, blueCol, maze);
                    }
                }
            }
        }
    }

    private static boolean isSuccessRed(final int redRow, final int redCol) {
        return redRow == redEnd[0] && redCol == redEnd[1];
    }

    private static boolean isSuccessBlue(final int blueRow, final int blueCol) {
        return blueRow == blueEnd[0] && blueCol == blueEnd[1];
    }

    private static void initPosition(final int[][] maze) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    redStart = new int[]{i, j};
                }

                if (maze[i][j] == 2) {
                    blueStart = new int[]{i, j};
                }

                if (maze[i][j] == 3) {
                    redEnd = new int[]{i, j};
                }

                if (maze[i][j] == 4) {
                    blueEnd = new int[]{i, j};
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 4}, {0, 0}, {2, 3}};

        // 3
        System.out.println(solution(maze));
    }
}

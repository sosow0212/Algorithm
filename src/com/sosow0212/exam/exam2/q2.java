package com.sosow0212.exam.exam2;

public class q2 {

    private static final int DEFAULT_COLOR_FREQUENCY = 0;

    public static int solution(int n, int k, int[][] grid) {
        int maxLineInSquare = 1;

        for (int line = n; line >= 1; line--) {
            for (int row = 0; row <= n - line; row++) {
                for (int col = 0; col <= n - line; col++) {
                    int[] colorsFrequency = countColorsFrequencyInSquare(n, grid, line, row, col);
                    int mostColorFrequencyCount = getMostColorFrequencyCount(k, colorsFrequency);
                    int needColor = (line * line) - mostColorFrequencyCount;

                    if (canDrawSquareWithSameColor(k, needColor)) {
                        maxLineInSquare = Math.max(maxLineInSquare, line);
                    }
                }
            }
        }

        return maxLineInSquare * maxLineInSquare;
    }

    private static int[] countColorsFrequencyInSquare(final int n,
                                                      final int[][] grid,
                                                      final int line,
                                                      final int row,
                                                      final int col) {
        int[] colorsFrequency = new int[n * n + 1];

        for (int i = row; i < row + line; i++) {
            for (int j = col; j < col + line; j++) {
                int color = grid[i][j];
                colorsFrequency[color]++;
            }
        }

        return colorsFrequency;
    }

    private static int getMostColorFrequencyCount(final int k, final int[] colorsFrequency) {
        int mostColorFrequencyCount = DEFAULT_COLOR_FREQUENCY;

        for (int i = 1; i <= k; i++) {
            mostColorFrequencyCount = Math.max(mostColorFrequencyCount, colorsFrequency[i]);
        }

        return mostColorFrequencyCount;
    }

    private static boolean canDrawSquareWithSameColor(final int k, final int needColorToMakeSquare) {
        return k >= needColorToMakeSquare;
    }

    public static void main(String[] args) {
        // 9
        System.out.println(solution(4, 3, new int[][]{{1, 2, 2, 2}, {1, 2, 1, 1}, {1, 2, 2, 1}, {3, 2, 1, 1}}));

        // 4
        System.out.println(solution(3, 2, new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 2, 4}}));

        // 4
        System.out.println(solution(2, 4, new int[][]{{1, 2}, {3, 4}}));
    }
}

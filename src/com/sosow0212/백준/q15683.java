package com.sosow0212.백준;

import java.util.Scanner;

public class q15683 {

    private static final int FOUND_CCTV = 20;
    private static final int WALL = 6;
    static int n;
    static int m;
    static int[][] map;
    static int[][] cctv;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        permutation(map);
        System.out.println(answer);
    }

    static void permutation(int[][] map) {
        int[] pos = findCctv(map);

        if (pos[0] == -1) {
            int temp = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        temp++;
                    }
                }
            }

            answer = Math.min(temp, answer);
            return;
        }

        int[][] newMap;
        if (pos[0] == 1) {
            newMap = copyMap(map);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

        } else if (pos[0] == 2) {
            newMap = copyMap(map);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

        } else if (pos[0] == 3) {
            newMap = copyMap(map);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

        } else if (pos[0] == 4) {
            newMap = copyMap(map);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);

            newMap = copyMap(map);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);
        } else if (pos[0] == 5) {
            newMap = copyMap(map);
            fillLeft(pos[0] + 100, pos[1], pos[2], newMap);
            fillRight(pos[0] + 100, pos[1], pos[2], newMap);
            fillUp(pos[0] + 100, pos[1], pos[2], newMap);
            fillUnder(pos[0] + 100, pos[1], pos[2], newMap);
            permutation(newMap);
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }

    private static void fillUp(int fillValue, int row, int col, int[][] map) {
        for (int i = row - 1; i >= 0; i--) {
            if (map[i][col] == WALL) {
                break;
            }
            if (map[i][col] == 0) {
                map[i][col] = fillValue;
            }
        }
    }

    private static void fillLeft(int fillValue, int row, int col, int[][] map) {
        for (int i = col - 1; i >= 0; i--) {
            if (map[row][i] == WALL) {
                break;
            }
            if (map[row][i] == 0) {
                map[row][i] = fillValue;
            }
        }
    }

    private static void fillUnder(int fillValue, int row, int col, int[][] map) {
        for (int i = row + 1; i < n; i++) {
            if (map[i][col] == WALL) {
                break;
            }
            if (map[i][col] == 0) {
                map[i][col] = fillValue;
            }
        }
    }

    private static void fillRight(int fillValue, int row, int col, int[][] map) {
        for (int i = col + 1; i < m; i++) {
            if (map[row][i] == WALL) {
                break;
            }
            if (map[row][i] == 0) {
                map[row][i] = fillValue;
            }
        }
    }

    static void unHandle(int cctvDir, int pos, int row, int col, int[][] map) {
        int fillValue = cctvDir + 100;
        if (cctvDir == 1) {
            if (pos == 0) {
                unFillRight(fillValue, row, col, map);
            }

            if (pos == 1) {
                unFillUnder(fillValue, row, col, map);
            }

            if (pos == 2) {
                unFillLeft(fillValue, row, col, map);
            }

            if (pos == 3) {
                unFillUp(fillValue, row, col, map);
            }
        } else if (cctvDir == 2) {
            // 좌 우
            if (pos == 1 || pos == 2) {
                unFillRight(fillValue, row, col, map);
                unFillLeft(fillValue, row, col, map);
            } else {
                // 상 하
                if (pos == 3 || pos == 4) {
                    unFillUnder(fillValue, row, col, map);
                    unFillUp(fillValue, row, col, map);
                }
            }
        } else if (cctvDir == 3) {
            if (pos == 1) {
                unFillRight(fillValue, row, col, map);
                unFillUp(fillValue, row, col, map);
            } else if (pos == 2) {
                unFillRight(fillValue, row, col, map);
                unFillUnder(fillValue, row, col, map);
            } else if (pos == 3) {
                unFillUnder(fillValue, row, col, map);
                unFillLeft(fillValue, row, col, map);
            } else if (pos == 4) {
                unFillLeft(fillValue, row, col, map);
                unFillUp(fillValue, row, col, map);
            }
        } else if (cctvDir == 4) {
            if (pos == 1) {
                unFillUp(fillValue, row, col, map);
                unFillRight(fillValue, row, col, map);
                unFillUnder(fillValue, row, col, map);
            } else if (pos == 2) {
                unFillLeft(fillValue, row, col, map);
                unFillRight(fillValue, row, col, map);
                unFillUnder(fillValue, row, col, map);
            } else if (pos == 3) {
                unFillUp(fillValue, row, col, map);
                unFillUnder(fillValue, row, col, map);
                unFillLeft(fillValue, row, col, map);
            } else if (pos == 4) {
                unFillUp(fillValue, row, col, map);
                unFillLeft(fillValue, row, col, map);
                unFillRight(fillValue, row, col, map);
            }
        } else if (cctvDir == 5) {
            unFillUp(fillValue, row, col, map);
            unFillRight(fillValue, row, col, map);
            unFillUnder(fillValue, row, col, map);
            unFillLeft(fillValue, row, col, map);
        }
    }

    private static void unFillUp(int fillValue, int row, int col, int[][] map) {
        for (int i = row - 1; i >= 0; i--) {
            if (map[i][col] == WALL) {
                break;
            }
            if (map[i][col] == fillValue) {
                map[i][col] = 0;
            }
        }
    }

    private static void unFillLeft(int fillValue, int row, int col, int[][] map) {
        for (int i = col - 1; i >= 0; i--) {
            if (map[row][i] == WALL) {
                break;
            }
            if (map[row][i] == fillValue) {
                map[row][i] = 0;
            }
        }
    }

    private static void unFillUnder(int fillValue, int row, int col, int[][] map) {
        for (int i = row + 1; i < n; i++) {
            if (map[i][col] == WALL) {
                break;
            }
            if (map[i][col] == fillValue) {
                map[i][col] = 0;
            }
        }
    }

    private static void unFillRight(int fillValue, int row, int col, int[][] map) {
        for (int i = col + 1; i < m; i++) {
            if (map[row][i] == WALL) {
                break;
            }
            if (map[row][i] == fillValue) {
                map[row][i] = 0;
            }
        }
    }

    static int[] findCctv(int[][] map) {
        int[] cctv = new int[]{-1, -1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) {
                    cctv = new int[]{map[i][j], i, j};
                    map[i][j] = FOUND_CCTV;
                    return cctv;
                }
            }
        }

        return cctv;
    }
}

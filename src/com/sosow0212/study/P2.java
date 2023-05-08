package com.sosow0212.study;

public class P2 {

    public int solution(int width, int height, int[][] diagonals) {

        return 0;
    }

    public static void main(String[] args) {
        P2 p2 = new P2();

        // 12
        System.out.println(p2.solution(2, 2, new int[][]{{1, 1}, {2, 2}}));

        // 3225685
        System.out.println(p2.solution(51, 37, new int[][]{{17, 19}}));
    }
}

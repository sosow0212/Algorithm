package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.Map;

public class qPccp10 {

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        Map<String, Integer> sortMap = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );

        Integer idx = sortMap.get(sort_by);

        answer = Arrays.stream(data)
                .filter(it -> it[1] < val_ext)
                .sorted((o1, o2) -> o1[idx] - o2[idx])
                .toArray(int[][]::new);

        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "data";
        int val_ext = 20300501;
        String sort_by = "remain";

        // [[3,20300401,10,8],[1,20300104,100,80]]
        System.out.println(Arrays.deepToString(solution(data, ext, val_ext, sort_by)));

    }
}

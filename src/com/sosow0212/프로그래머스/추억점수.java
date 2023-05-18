package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;

class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int count = 0;
            for (int j = 0; j < photo[i].length; j++) {
                count += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        추억점수 sol = new 추억점수();

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

//        System.out.println(Arrays.toString(sol.solution(name, yearning, photo)));

        // 5, 15, 0
        String[][] photo2 = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};
        System.out.println(Arrays.toString(sol.solution(name, yearning, photo2)));
    }
}

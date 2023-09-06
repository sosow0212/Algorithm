package com.sosow0212.프로그래머스다시;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 영끝 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int round = 1;
        List<String> dict = new LinkedList<>();

        Queue<String> q = new LinkedList<>(Arrays.asList(words));
        String before = q.remove();
        dict.add(before);
        int index = 1;

        while (!q.isEmpty()) {
            if (index == n) {
                index = 0;
                round++;
            }

            index++;
            String now = q.remove();

            char lastC = before.charAt(before.length() - 1);
            if (now.charAt(0) != lastC || dict.contains(now)) {
                answer[0] = index;
                answer[1] = round;
                return answer;
            }

            before = now;
            dict.add(now);
        }


        return answer;
    }

    public static void main(String[] args) {
        영끝 sol = new 영끝();

        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(sol.solution(n1, words1))); // 3 3

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(Arrays.toString(sol.solution(n2, words2))); // 0 0


        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(sol.solution(n3, words3))); // 1 3
    }
}

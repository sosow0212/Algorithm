package com.sosow0212.with_ure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 영어끝말잇기 {

    public static int[] solution(int n, String[] words) {
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
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        // 3, 3
        System.out.println(Arrays.toString(solution(3, words)));

        // 0, 0
//        System.out.println(Arrays.toString(solution(5, words2)));

        // 1, 3
//        System.out.println(Arrays.toString(solution(2, words3)));
    }
}

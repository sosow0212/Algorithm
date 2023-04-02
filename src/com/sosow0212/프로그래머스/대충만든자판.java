package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 대충만든자판 {

    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i + 1);
                }
            }
        }

        for (String target : targets) {
            int count = 0;

            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);

                if (!map.containsKey(c)) {
                    count = -1;
                    break;
                }

                count += map.get(c);
            }

            answer.add(count);
        }

        return answer;
    }

    public static void main(String[] args) {
        대충만든자판 sol = new 대충만든자판();
        String[] keyMap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        System.out.println(sol.solution(keyMap, targets));
    }
}

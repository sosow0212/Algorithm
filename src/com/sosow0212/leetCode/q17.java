package com.sosow0212.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q17 {

    static Map<Integer, List<Character>> map;
    static List<String> answer;

    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        initMap();

        if (digits.isEmpty()) {
            return answer;
        }

        permutation(0, digits, new StringBuilder());
        return answer;
    }

    static void permutation(int index, String digits, StringBuilder sum) {
        if (index == digits.length()) {
            answer.add(sum.toString());
            return;
        }

        int button = digits.charAt(index) - '0';
        List<Character> list = map.get(button);

        for (int i = 0; i < list.size(); i++) {
            sum.append(list.get(i));
            permutation(index + 1, digits, sum);
            sum.deleteCharAt(index);
        }
    }

    private static void initMap() {
        map = new HashMap<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        q17 sol = new q17();
        System.out.println(sol.letterCombinations("23"));
    }
}

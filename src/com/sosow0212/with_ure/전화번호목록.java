package com.sosow0212.with_ure;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, String> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, "");
        }

        for (String s : phone_book) {

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(solution(phoneBook)); // false

        System.out.println(solution(new String[]{"123", "456", "789"})); // true
    }
}

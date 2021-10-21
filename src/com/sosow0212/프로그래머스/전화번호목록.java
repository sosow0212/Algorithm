package com.sosow0212.프로그래머스;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42577


public class 전화번호목록 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"123", "456", "789"}));
    }
}


class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> hashMap = new HashMap<String, String>();

        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], " ");
        }

        for (String p : phone_book) {
            for (int i = 0; i < p.length(); i++) {
                if (hashMap.containsKey(p.substring(0, i))) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}
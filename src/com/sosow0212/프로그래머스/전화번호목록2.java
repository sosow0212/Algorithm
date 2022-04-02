package com.sosow0212.프로그래머스;

import java.util.HashMap;

class 전화번호목록2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> hashMap = new HashMap<>();

        for(String str : phone_book) {
            hashMap.put(str, " ");
        }

        for(String str : phone_book) {
            for(int i=0; i<str.length(); i++) {
                if(hashMap.containsKey(str.substring(0,i))) {
                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        전화번호목록2 sol = new 전화번호목록2();
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(sol.solution(phone_book));
    }
}
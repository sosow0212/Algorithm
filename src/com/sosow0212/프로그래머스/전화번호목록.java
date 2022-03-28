package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        // 119, 1195524421, 97674223

        HashMap<String, String> hashMap = new HashMap<>();
        for(int i=0; i< phone_book.length; i++) {
            hashMap.put(phone_book[i], " ");
        }

        // "119", " "
        for(String str : phone_book) {
            for(int i=0; i<str.length(); i++) {
                if(hashMap.containsKey(str.substring(0,i))) {
                    answer = false;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        전화번호목록 sol = new 전화번호목록();
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(sol.solution(phone_book));
    }
}

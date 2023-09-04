package com.sosow0212.프로그래머스다시;

import java.util.HashMap;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        HashMap<String, String> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, "");
        }

        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            boolean end = false;

            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        전화번호목록 sol = new 전화번호목록();

        String[] s1 = {"119", "97674223", "1195524421"};
        System.out.println(sol.solution(s1)); // false

        String[] s2 = {"123", "456", "789"};
        System.out.println(sol.solution(s2)); // true

        String[] s3 = {"12", "123", "1235", "567", "88"};
        System.out.println(sol.solution(s3)); // false;
    }
}

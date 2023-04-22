package com.sosow0212.프로그래머스;

import java.util.LinkedHashSet;
import java.util.Set;

public class 중복된문자제거 {

    public String solution(String my_string) {
        Set<Character> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            set.add(my_string.charAt(i));
        }

        for (Character c : set) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        중복된문자제거 sol = new 중복된문자제거();

        String str = "We are the world";
        System.out.println(sol.solution(str));
    }
}

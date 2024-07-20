package com.sosow0212.프로그래머스다시;

public class 제이든케이스 {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] split = s.split(" ");
        for (String st : split) {
            if (st.isEmpty()) {
                sb.append(" ");
                continue;
            }

            sb.append(st.substring(0, 1).toUpperCase());
            sb.append(st.substring(1).toLowerCase());
            sb.append(" ");
        }

        if (s.endsWith(" ")) {
            return sb.toString();
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solution(" a b "));
    }
}

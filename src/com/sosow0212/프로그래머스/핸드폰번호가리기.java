package com.sosow0212.프로그래머스;

public class 핸드폰번호가리기 {
    static public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        String answer = phone_number.substring(phone_number.length() - 4);
        for(int i=0; i<phone_number.length() - 4; i++) {
            sb.append('*');
        }
        sb.append(answer);


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("01012345678"));
    }
}

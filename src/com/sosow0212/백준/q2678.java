package com.sosow0212.백준;

public class q2678 {

    public int countSeniors(String[] details) {
        // 11 ~ 13
        int answer = 0;
        for(String s : details) {
            if(Integer.parseInt(s.substring(11, 13)) > 60) {
                answer++;
            }
        }

        return answer;
    }
}

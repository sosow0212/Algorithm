package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자짝꿍 {
    static public String solution(String x, String y) {
        String answer = "";

        boolean[] checkY = new boolean[y.length()];

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<x.length(); i++) {
            for(int j=0; j<y.length(); j++) {
                if(x.charAt(i) == y.charAt(j) && checkY[j] == false) {
                    checkY[j] = true;
                    list.add(Integer.parseInt(Character.toString(y.charAt(j))));
                }
            }
        }

        if(list.size() == 0) {
            return "-1";
        }

        if(list.get(0) == 0) {
            return "0";
        }

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        for(int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String x = "1234";
        String y = "4321";
        System.out.println(solution(x, y));
    }
}

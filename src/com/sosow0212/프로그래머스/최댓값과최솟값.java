package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        String temp = "";
        List<Integer> ans = new ArrayList<>();

        String str = s.replaceAll(" ", ",");
        str += ",";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                ans.add(Integer.parseInt(temp));
                temp = "";
            } else {
                temp += str.charAt(i);
            }
        }

        Collections.sort(ans);

        answer += String.valueOf(ans.get(0));
        answer += String.valueOf(" " + ans.get(ans.size() - 1));
        return answer;
    }

    public static void main(String[] args) {
        최댓값과최솟값 sol = new 최댓값과최솟값();
        System.out.println(sol.solution("-1 -2 -3 -4")); // "1 4"
    }
}

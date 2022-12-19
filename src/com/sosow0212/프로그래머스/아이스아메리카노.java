package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 아이스아메리카노 {
    static public List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        answer.add(money / 5500);
        answer.add(money - answer.get(0) * 5500);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15000)); // 2, 4000
    }
}

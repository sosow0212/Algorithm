package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class x만큼간격이있는n개의숫자 {
    static public List<Long> solution(int x, int n) {
        List<Long> answer = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            answer.add((long)x * i);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}

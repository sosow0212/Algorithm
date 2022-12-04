package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 배열뒤집기 {
    static public List<Integer> solution(int[] num_list) {
        List<Integer> answer = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 0, 1, 1, 1, 3, 5}); // 5,3,1,1,1,0,1
        String str = "ds";
        str.length();
    }
}

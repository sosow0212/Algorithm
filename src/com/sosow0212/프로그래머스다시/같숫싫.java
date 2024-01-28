package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 같숫싫 {

    public List<Integer> solution(int[] arr) {
        int[] answer = new int[arr.length];

        Arrays.fill(answer, -1);
        answer[0] = arr[0];
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (answer[index] == arr[i]) {
                continue;
            } else {
                index++;
                answer[index] = arr[i];
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != -1) {
                list.add(answer[i]);
            }
        }

        return list;
    }
}

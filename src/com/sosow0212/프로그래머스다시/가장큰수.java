package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 가장큰수 {

    static String[] strNumbers;
    static boolean[] visited;
    static List<Integer> list;

    public String solution(int[] numbers) {
        list = new ArrayList<>();
        strNumbers = new String[numbers.length];
        visited = new boolean[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        permutation(0, "");
        Collections.sort(list);
        return String.valueOf(list.get(list.size() - 1));
    }

    public void permutation(int index, String sum) {
        if (index == strNumbers.length) {
            list.add(Integer.parseInt(sum));
            return;
        }

        for (int i = 0; i < strNumbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, sum + strNumbers[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        가장큰수 sol = new 가장큰수();
        int[] numbers = {6, 10, 2};

        // 6210
        System.out.println(sol.solution(numbers));
    }
}

package com.sosow0212.프로그래머스.스킬체크1;

import java.util.Arrays;
import java.util.Collections;

public class numberSort {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        Integer[] arr = new Integer[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());
        String ansString = "";
        for (int i = 0; i < arr.length; i++) {
            ansString += String.valueOf(arr[i]);
        }

        answer = Long.parseLong(ansString);
        return answer;
    }

    public static void main(String[] args) {
        numberSort numberSort = new numberSort();
        long n = 118372;
        System.out.println(numberSort.solution(n));
    }
}

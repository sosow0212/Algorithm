package com.sosow0212.test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String str = "제이엠";
        String str2 = "제이슨";
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(5);
        answer.add(3);
        Collections.sort(answer, Comparator.reverseOrder());

        System.out.println(str.substring(0,1));

    }
}

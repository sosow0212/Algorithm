package com.sosow0212.프로그래머스;

import java.util.*;

public class 배열원소의길이 {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }
}

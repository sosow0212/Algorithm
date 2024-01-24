package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;

public class 호텔방배정 {

    private static HashMap<Long, Long> map;
    static long[] answer;
    static int index;

    public static long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];
        map = new HashMap<>();
        index = 0;

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    static long find(long x) {
        if (!map.containsKey(x)) {
            map.put(x, x + 1);
            return x;
        }

        long emptyRoom = find(map.get(x));
        map.put(x, emptyRoom);
        return emptyRoom;
    }

    public static void main(String[] args) {
        // 1 3 4 2 5 6
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }
}

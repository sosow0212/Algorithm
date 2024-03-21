package com.sosow0212.프로그래머스다시;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {

    static Map<Long, Long> map;

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[(int) room_number.length];
        map = new HashMap<>();

        for (long i = 0; i < room_number.length; i++) {
            long number = room_number[(int) i];

            long myRoom = find(number);
            answer[(int) i] = myRoom;
        }

        return answer;
    }

    static long find(long x) {
        if (!map.containsKey(x)) {
            // 방이 없다면 배정
            map.put(x, x + 1);
            return x;
        }

        // 방을 찾는다
        long findRoom = find(map.get(x));
        map.put(x, findRoom);

        return findRoom;
    }

    public static void main(String[] args) {
        // [1,3,4,2,5,6]
        System.out.println(Arrays.toString(solution(10, new long[]{1, 3, 4, 1, 3, 1})));
    }
}

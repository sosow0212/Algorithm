package com.sosow0212.woowa_study.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startTime = getTime(st.nextToken());
        int endTime = getTime(st.nextToken());
        int endStreaming = getTime(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        String input = null;
        while ((input = br.readLine()) != null) {
            System.out.println(input);
            int nowTime = getTime(input.split(" ")[0]);
            String nickname = input.split(" ")[1];

            if (nowTime <= startTime) {
                map.put(nickname, map.getOrDefault(nickname, 0) + 1);
            } else if (nowTime >= endTime && nowTime <= endStreaming) {
                map.put(nickname, map.getOrDefault(nickname, 0) + 3);
            }
        }

        System.out.println(map);

        long count = map.keySet()
                .stream()
                .filter(key -> map.get(key).equals(4))
                .count();

        System.out.println(count);
    }

    public static int getTime(final String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int min = Integer.parseInt(split[1]);

        return hour + min;
    }
}

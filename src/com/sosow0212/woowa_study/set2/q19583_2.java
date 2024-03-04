package com.sosow0212.woowa_study.set2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q19583_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String startTime = st.nextToken();
        String endTime = st.nextToken();
        String limit = st.nextToken();
        String str = null;

        Map<String, Integer> map = new HashMap<>();
        while ((str = br.readLine()) != null) {
            String[] split = str.split(" ");

            int time = getTime(split[0]);
            String nickname = split[1];

            if (time < getTime(startTime)) {
                map.put(nickname, 1);
                continue;
            }

            if (time >= getTime(endTime)
                    && time <= getTime(limit)
                    && map.containsKey(nickname)
                    && map.get(nickname) == 1) {
                map.put(nickname, 0);
            }
        }

        int count = (int) map.keySet().stream()
                .filter(it -> map.get(it) == 1)
                .count();

        System.out.println(count);
    }

    static int getTime(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}

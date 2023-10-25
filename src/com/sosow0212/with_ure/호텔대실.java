package com.sosow0212.with_ure;

import java.util.PriorityQueue;

public class 호텔대실 {

    public static int solution(String[][] book_time) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (String[] time : book_time) {
            int startTime = convertTime(time[0]);
            int endTime = convertTime(time[1]);

            pq.add(new int[]{startTime, endTime});
        }

        int[] poll = pq.poll();
        while(!pq.isEmpty()) {

        }

        return answer;
    }

    public static int convertTime(final String time) {
        String[] timeSplit = time.split(":");

        return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
    }

    public static void main(String[] args) {
        String[][] bookTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        // 3
        System.out.println(solution(bookTime));
    }
}

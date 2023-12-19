package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {

    public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] books = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            int startTime = parseTime(book_time[i][0]);
            int endTime = parseTime(book_time[i][1]) + 10;

            if (endTime % 100 >= 60) {
                endTime += 40;
            }

            books[i][0] = startTime;
            books[i][1] = endTime;
        }

        /**
         * [860, 920]   ~ 14:20 ~ 15:20 (2)
         * [900, 1020]  ~ 15:00 ~ 17:00 (3)
         * [1000, 1100] ~ 16:40 ~ 18:20 (2)
         * [850, 1160]  ~ 14:10 ~ 19:20 (1)
         * [1100, 1280] ~ 18:20 ~ 21:20 (3)
         */
        Arrays.sort(books, (a, b) -> {

            if (a[0] > b[0]) return 1;
            else if (a[0] < b[0]) return -1;
            else {
                if (a[1] > b[1]) return 1;
                else return -1;
            }
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int[] book : books) {
            if (rooms.isEmpty()) {
                rooms.add(book[1]);
                continue;
            }

            Integer last = rooms.peek();
            if (book[0] >= last) {
                rooms.poll();
                rooms.add(book[1]);
            } else {
                rooms.add(book[1]);
            }
        }

        return rooms.size();
    }

    private static int parseTime(String time) {
        String[] split = time.split(":");

        String hour = split[0];
        String min = split[1];

        return Integer.parseInt(hour) * 60 + Integer.parseInt(min);
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        // 3
        System.out.println(solution(book_time));
    }
}

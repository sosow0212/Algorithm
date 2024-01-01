package com.sosow0212.프로그래머스;

public class 광고삽입 {

    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = parseInteger(play_time);
        int advTime = parseInteger(adv_time);

        int[] ad = new int[360000];

        // 1. 누적합
        for (String log : logs) {
            String[] timeStamp = log.split("-");

            int startLog = parseInteger(timeStamp[0]);
            int endLog = parseInteger(timeStamp[1]);

            for (int i = startLog; i < endLog; i++) {
                ad[i]++;
            }
        }

        // 2. 하나씩 뒤로 땡기면서 최대값 갱신
        int maxIndex = 0;
        long maxSum = 0;
        long sum = 0;

        for (int i = 0; i < advTime; i++) {
            maxSum += ad[i];
        }
        maxSum = sum;

        for (int i = advTime; i < playTime; i++) {
            sum += ad[i] - ad[i - advTime];

            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = i - advTime + 1;
            }
        }

        return parseString(maxIndex);
    }

    static int parseInteger(final String time) {
        String[] times = time.split(":");

        int result = 0;

        result += Integer.parseInt(times[0]) * 3600;
        result += Integer.parseInt(times[1]) * 60;
        result += Integer.parseInt(times[2]);

        return result;
    }

    static String parseString(int time) {
        int hour = time / 3600;
        String result = "";

        time %= 3600;
        if (hour < 10) {
            result += "0";
        }

        result += hour + ":";

        int min = time / 60;
        time %= 60;
        if (min < 10) {
            result += "0";
        }
        result += min + ":";

        int sec = time;
        if (sec < 10) {
            result += "0";
        }
        result += sec;

        return result;
    }

    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        // 01:30:59
        System.out.println(solution(play_time, adv_time, logs));


        String p1 = "99:59:59";
        String p2 = "25:00:00";
        String[] p3 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        System.out.println(solution(p1, p2, p3));
    }
}

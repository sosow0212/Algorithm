package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 방금그곡 {

    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        Map<String, String> flowAndMusic = new LinkedHashMap<>();
        Map<String, Integer> musicAndPlayTime = new LinkedHashMap<>();

        for (String musicInfo : musicinfos) {
            String[] infos = musicInfo.split(",");

            String startTime = infos[0];
            String endTime = infos[1];
            String title = infos[2];
            String givenMusic = infos[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

            int playTime = getPlayTime(startTime, endTime);
            musicAndPlayTime.put(title, playTime);

            if (playTime < givenMusic.length()) {
                givenMusic = givenMusic.substring(0, playTime);
            } else if (playTime > givenMusic.length()) {
                // C# 고려 해야함
                int repeat = playTime / givenMusic.length();
                int mod = playTime % givenMusic.length();

                givenMusic = givenMusic.repeat(repeat) + givenMusic.substring(0, mod);
            }

            flowAndMusic.put(givenMusic, title);
        }

        int count = 0;
        List<String> answerKey = new ArrayList<>();
        for (String flow : flowAndMusic.keySet()) {
            if (flow.contains(m)) {
                count++;
                answerKey.add(flowAndMusic.get(flow));
            }
        }

        if (count == 1) {
            return answerKey.get(0);
        } else if (count >= 2) {
            String longestMusicTitle = "";
            int maxTime = Integer.MIN_VALUE;

            for (String s : answerKey) {
                Integer time = musicAndPlayTime.get(s);
                if (time > maxTime) {
                    maxTime = time;
                    longestMusicTitle = s;
                }
            }

            return longestMusicTitle;
        }

        return "(None)";
    }

    static int getPlayTime(String startTime, String endTime) {
        String[] startTimeSplit = startTime.split(":");
        String[] endTimeSplit = endTime.split(":");

        int startTimeMin = Integer.parseInt(startTimeSplit[0]) * 60 + Integer.parseInt(startTimeSplit[1]);
        int endTimeMin = Integer.parseInt(endTimeSplit[0]) * 60 + Integer.parseInt(endTimeSplit[1]);

        return endTimeMin - startTimeMin;
    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicInfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicInfos)); // "HELLO"

        String m1 = "CC#BCC#BCC#BCC#B";
        String[] infos1 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m1, infos1)); // "FOO

        String m2 = "ABC";
        String[] infos2 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m2, infos2)); // "WORLD"


    }
}

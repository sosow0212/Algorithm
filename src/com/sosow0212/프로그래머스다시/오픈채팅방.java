package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public static List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();

        Map<String, String> user = new HashMap<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            String uid = split[1];

            if (command.equals("Enter")) {
                user.put(uid, split[2]);
                continue;
            }

            if (command.equals("Change")) {
                user.put(uid, split[2]);
            }
        }

        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            String uid = split[1];

            if (command.equals("Enter")) {
                answer.add(user.get(uid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answer.add(user.get(uid) + "님이 나갔습니다.");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        // [
        // "Prodo님이 들어왔습니다.",
        // "Ryan님이 들어왔습니다.",
        // "Prodo님이 나갔습니다.",
        // "Prodo님이 들어왔습니다."
        // ]
        System.out.println(solution(record));
    }
}

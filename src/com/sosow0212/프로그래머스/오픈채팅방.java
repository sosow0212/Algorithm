package com.sosow0212.프로그래머스;

import java.util.*;

public class 오픈채팅방 {
    static public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();

        HashMap<String, String> info = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for(String r : record) {
            String input = r.split(" ")[0];
            String uid = r.split(" ")[1];

            if(input.equals("Enter")) {
                String name = r.split(" ")[2];
                info.put(uid, name);
                queue.add("Enter " + uid);
            } else if(input.equals("Change")) {
                String name = r.split(" ")[2];
                info.put(uid, name);
                queue.add("Change " + uid);
            } else {
                String name = info.get(uid);
                queue.add("Leave " + uid);
            }
        }

        for(String e : queue) {
            String input = e.split(" ")[0];
            String uid = e.split(" ")[1];

            if(input.equals("Enter")) {
                answer.add(info.get(uid) + "님이 들어왔습니다.");
            } else if (input.equals("Change")) {
                continue;
            } else {
                answer.add(info.get(uid) + "님이 나갔습니다.");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }
}

package com.sosow0212.woowa;

import java.util.*;

public class woowa7 {

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user, friends, visitors));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Set<String> myFrinedSet = new HashSet<>();
        friends.stream().filter(friendsList -> isMyFriend(user, friendsList.get(1))).map(friendsList -> myFrinedSet.add(friendsList.get(0)));
        System.out.println(myFrinedSet);

        return answer;
    }

    public static boolean isMyFriend(String user, String me) {
        if(user.equals(me)) return true;
        return false;
    }
}



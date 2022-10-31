package com.sosow0212.woowa;

import java.util.*;

public class ttest {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"), // true
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko") // true
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        System.out.println(solution(user, friends, visitors));
    }

    static HashMap<String, Integer> userScore = new HashMap<>();


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Set<String> myFriends = new HashSet<>(); // mrko, donut, shak

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                myFriends.add(friend.get(0));
            }
        }

        System.out.println(myFriends);

        // 10점씩 넣기
        for (List<String> friend : friends) {
            if (myFriends.contains(friend.get(0)) || myFriends.contains(friend.get(1))) {
                updateRecommendScore(friend.get(0), 10);
                updateRecommendScore(friend.get(1), 10);
            }
        }

        // 1점씩 넣기
        for(String visitor : visitors) {
            updateRecommendScore(visitor, 1);
        }

        // 점수 0점
        for(String key : userScore.keySet()) {
            if(userScore.get(key) == 0) {
                userScore.remove(key);
            }
        }

        //user와 친구인 사람
        for(String myFriend : myFriends) {
            if(userScore.containsKey(myFriend)) {
                userScore.remove(myFriend);
            }
        }


        System.out.println(userScore);

        return answer;
    }

    public static void updateRecommendScore(String user, int score) {
        userScore.put(user, userScore.getOrDefault(user, 0) + score);
    }
}

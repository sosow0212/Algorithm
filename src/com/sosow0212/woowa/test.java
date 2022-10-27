package com.sosow0212.woowa;

import java.util.*;
import java.util.stream.Collectors;

public class test {

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


    private static final Map<String, Integer> userToScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Set<String> myFriendsSet = new HashSet<>();

        // 친구 셋 모두 넣기 (유저 기준)
        for(List<String> friend : friends) {
            if(isFriendsContainUser(friend, user)) {
                myFriendsSet.addAll(friend);
            }
        }


        for(List<String> friend : friends) {
            if(myFriendsSet.contains(friend.get(0)) || myFriendsSet.contains(friend.get(1))) {
                updateRecommendScore(friend.get(0), 10);
                updateRecommendScore(friend.get(1), 10);
            }
        }

        // 방문자는 점수 처리
        for(String visitor : visitors) {
            updateRecommendScore(visitor, 1);
        }

        // 자신과 친구면 제거
        for(String friend : myFriendsSet) {
            userToScore.remove(friend);
        }

        // value == 0 이라면 제거
        for(String key : userToScore.keySet()) {
            if(userToScore.get(key) == 0) {
                userToScore.remove(key);
            }
        }

        // 정렬 1순위 값 / 2순위 키
        answer = userToScore.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());

         return answer;
    }

    public static boolean isFriendsContainUser(List<String> friends, String user) {
        return friends.contains(user);
    }

    public static void updateRecommendScore(String user, int score) {
        userToScore.put(user, userToScore.getOrDefault(user, 0) + score);
    }
}

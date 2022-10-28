//package onboarding;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Problem7 {
//
//    // 추후에 모든 문제에 private 추가해야함
//    private static final Map<String, Integer> userAndScoreMap = new HashMap<>();
//    private static final Set<String> myFriendsSet = new HashSet<>();
//
//    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        friendsSetup(friends, user);
//        updateScore(friends, visitors);
//        removeMyFriendsAndValueIsZero();
//
//        // 정렬 1순위 값 / 2순위 키
//        List<String> answer = userAndScoreMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .map(Map.Entry::getKey)
//                .limit(5)
//                .collect(Collectors.toList());
//
//        return answer;
//    }
//
//
//    // 자신과 친구이거나, value == 0 이라면 userAndScoreMap에서 키 제거
//    public static void removeMyFriendsAndValueIsZero() {
//        // 자신과 친구면 제거
//        for (String friend : myFriendsSet) {
//            userAndScoreMap.remove(friend);
//        }
//
//        // value == 0 이라면 제거
//        for (String key : userAndScoreMap.keySet()) {
//            if (userAndScoreMap.get(key) == 0) {
//                userAndScoreMap.remove(key);
//            }
//        }
//    }
//
//    // 연관관계와 방문자 점수 처리
//    public static void updateScore(List<List<String>> friends, List<String> visitors) {
//        // 연관관계 점수 처리
//        for (List<String> friend : friends) {
//            if (myFriendsSet.contains(friend.get(0)) || myFriendsSet.contains(friend.get(1))) {
//                updateRecommendScore(friend.get(0), 10);
//                updateRecommendScore(friend.get(1), 10);
//            }
//        }
//
//        // 방문자 점수 처리
//        for (String visitor : visitors) {
//            updateRecommendScore(visitor, 1);
//        }
//    }
//
//    public static void updateRecommendScore(String user, int score) {
//        userAndScoreMap.put(user, userAndScoreMap.getOrDefault(user, 0) + score);
//    }
//
//    // user의 친구 관계 구하는 메서드
//    public static void friendsSetup(List<List<String>> friends, String user) {
//        // user의 친구 관계 구하는 메서드
//        for (List<String> friend : friends) {
//            if (isFriendsContainUser(friend, user)) {
//                myFriendsSet.addAll(friend);
//            }
//        }
//    }
//
//    public static boolean isFriendsContainUser(List<String> friends, String user) {
//        return friends.contains(user);
//    }
//
//
//}

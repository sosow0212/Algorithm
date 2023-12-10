package com.sosow0212.exam.kin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class q1_2 {

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> friendsToNumber = new HashMap<>();
        Map<Integer, String> friendsByNumber = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsToNumber.put(friends[i], i);
            friendsByNumber.put(i, friends[i]);
        }

        Map<String, Integer> giftPoints = new LinkedHashMap<>(); // 선물지수
        Map<String, Integer> result = new HashMap<>(); // 결과

        for (String friend : friends) {
            giftPoints.put(friend, 0);
            result.put(friend, 0);
        }
        makeGiftPoints(gifts, giftPoints);

        int n = friends.length;
        int[][] map = new int[n][n];

        for (String gift : gifts) {
            String giver = gift.split(" ")[0];
            String taker = gift.split(" ")[1];

            map[friendsToNumber.get(giver)][friendsToNumber.get(taker)]++;
        }

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (!visited[i][j] && !visited[j][i]) {
                    int giverPoint = map[i][j];
                    int takerPoint = map[j][i];

                    if (giverPoint > takerPoint) {
                        result.put(friendsByNumber.get(i), result.getOrDefault(friendsByNumber.get(i), 0) + 1);
                    } else if (giverPoint < takerPoint) {
                        result.put(friendsByNumber.get(j), result.getOrDefault(friendsByNumber.get(j), 0) + 1);
                    } else {
                        if (giftPoints.get(friendsByNumber.get(i)) > giftPoints.get(friendsByNumber.get(j))) {
                            result.put(friendsByNumber.get(i), result.getOrDefault(friendsByNumber.get(i), 0) + 1);
                        } else if (giftPoints.get(friendsByNumber.get(j)) > giftPoints.get(friendsByNumber.get(i))) {
                            result.put(friendsByNumber.get(j), result.getOrDefault(friendsByNumber.get(j), 0) + 1);
                        }
                    }
                }

                visited[i][j] = true;
                visited[j][i] = true;
            }
        }

        for (Integer value : result.values()) {
            answer = Math.max(value, answer);
        }

        return answer;
    }

    private static void makeGiftPoints(final String[] gifts, final Map<String, Integer> giftPoints) {
        for (String gift : gifts) {
            String[] giftInfo = gift.split(" ");
            String giver = giftInfo[0];
            String taker = giftInfo[1];
            giftPoints.put(giver, giftPoints.getOrDefault(giver, 0) + 1);
            giftPoints.put(taker, giftPoints.getOrDefault(taker, 0) - 1);
        }
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        // 2
        System.out.println(solution(friends, gifts));

        String[] f = {"joy", "brad", "alessandro", "conan", "david"};
        String[] g = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(f, g)); // 4
    }
}

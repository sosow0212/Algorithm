package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> giftPoints = new HashMap<>();
        Map<String, Map<String, Integer>> history = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (String f : friends) {
            history.put(f, new HashMap<>());
            giftPoints.put(f, 0);
            result.put(f, 0);
        }

        // 1. 선물 정보 Map 초기화
        for (int i = 0; i < friends.length; i++) {
            Map<String, Integer> takerInfo = history.get(friends[i]);

            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                takerInfo.put(friends[j], 0);
            }
        }

        // 2. 선물지수 초기화
        for (String gift : gifts) {
            String[] infos = gift.split(" ");
            String giver = infos[0];
            String taker = infos[1];

            giftPoints.put(giver, giftPoints.getOrDefault(giver, 0) + 1);
            giftPoints.put(taker, giftPoints.getOrDefault(taker, 0) - 1);

            Map<String, Integer> takersMap = history.get(giver);
            takersMap.put(taker, takersMap.getOrDefault(taker, 0) + 1);
        }

        // 3. 받은 선물 계산
        for (int i = 0; i < friends.length - 1; i++) {
            String giver = friends[i];
            Map<String, Integer> takersInfoByGiver = history.get(giver);

            for (int j = i + 1; j < friends.length; j++) {
                String taker = friends[j];
                Map<String, Integer> takersInfoByTaker = history.get(taker);

                int countGiftOfGiver = takersInfoByGiver.get(taker);
                int countGiftOfTaker = takersInfoByTaker.get(giver);

                if (countGiftOfGiver > countGiftOfTaker) {
                    // giver가 선물을 받는 경우
                    result.put(giver, result.getOrDefault(giver, 0) + 1);
                } else if (countGiftOfGiver < countGiftOfTaker) {
                    // taker가 선물을 받는 경우
                    result.put(taker, result.getOrDefault(taker, 0) + 1);
                } else {
                    // 동점인 경우 : 선물 점수 비교
                    int giverGiftPoint = giftPoints.get(giver);
                    int takerGiftPoint = giftPoints.get(taker);

                    if (giverGiftPoint > takerGiftPoint) {
                        result.put(giver, result.getOrDefault(giver, 0) + 1);
                    } else if (giverGiftPoint < takerGiftPoint) {
                        result.put(taker, result.getOrDefault(taker, 0) + 1);
                    } else {
                        // 동점인 경우 아무도 선물을 받지 않음
                    }
                }
            }
        }

        int max = 0;
        for (int v : result.values()) {
            max = Math.max(max, v);
        }

        return max;
    }
}

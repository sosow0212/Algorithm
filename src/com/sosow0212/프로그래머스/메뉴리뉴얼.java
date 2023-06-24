package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼 {

    List<String> answerList;
    Map<String, Integer> hashMap;

    public String[] solution(String[] orders, int[] course) {
        answerList = new ArrayList<>();
        hashMap = new HashMap<>();

        // 1. 각 Order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 각 order를 기준으로 courseLength 만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders)
                combination("", order, courseLength);

            // 3. 가장 많은 조합 answer에 저장
            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                if (max > 1)
                    for (String key : hashMap.keySet())
                        if (hashMap.get(key) == max)
                            answerList.add(key);
                hashMap.clear();
            }
        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        return answer;
    }

    public void combination(String order, String others, int count) {
        // 탈출 조건 : count == 0
        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        // 0부터 length까지 조합
        for (int i = 0; i < others.length(); i++)
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
    }

    public static void main(String[] args) {
        메뉴리뉴얼 sol = new 메뉴리뉴얼();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // ["AC", "ACDE", "BCFG", "CDE"]
        System.out.println(Arrays.toString(sol.solution(orders, course)));

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

        // "ACD", "AD", "ADE", "CD", "XYZ"
        System.out.println(Arrays.toString(sol.solution(orders2, course2)));
    }
}

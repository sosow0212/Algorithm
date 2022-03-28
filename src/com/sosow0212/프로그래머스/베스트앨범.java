package com.sosow0212.프로그래머스;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }


        // 해시 밸류 기준 정렬
        List<String> keySetList = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySetList, ((o1, o2) -> (hashMap.get(o2).compareTo(hashMap.get(o1)))));


        for (String key : keySetList) {
            HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();

            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i])) {
                    hs.put(i, plays[i]);
                }
            }
            List<Integer> keyLists = new ArrayList<>(hs.keySet());
            keyLists.sort((s1, s2) -> hs.get(s2).compareTo(hs.get(s1)));
            int j = 0;
            for (Integer c : keyLists) {
                if (j > 1) {
                    break;
                }
                answerList.add(c);
                j++;
            }
        }

        answer = new int[answerList.size()];
        for(int i=0; i< answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        베스트앨범 sol = new 베스트앨범();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] ans = sol.solution(genres, plays);
        for(int i=0; i< ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}

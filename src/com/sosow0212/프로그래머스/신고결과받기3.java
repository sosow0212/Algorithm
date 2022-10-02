package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기3 {
    static public int[] solution(String[] idList, String[] report, int k) {
        int[] answer = new int[idList.length];

        HashSet<String> hashSet = new HashSet<>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        HashMap<String, Integer> reportHashMap = new HashMap<>();

        // report 배열 중복 제거
        for (String rep : report) {
            hashSet.add(rep);
        }

        // 신고당한사람 : List(신고자들)
        for (String str : hashSet) {
            String reporter = str.split(" ")[0];
            String reported = str.split(" ")[1];

            ArrayList<String> reporterList = hashMap.getOrDefault(reported, null);
            if (reporterList == null) {
                reporterList = new ArrayList<>();
            }

            reporterList.add(reporter);
            hashMap.put(reported, reporterList);
        }

        // reportHashMap에 신고당한사람 : 신고횟수넣기
        for (ArrayList<String> reporterList : hashMap.values()) {
            if (reporterList.size() >= k) {
                for (String reporter : reporterList) {
                    reportHashMap.put(reporter, reportHashMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        // answer 채우기
        for (int i = 0; i < idList.length; i++) {
            answer[i] = reportHashMap.getOrDefault(idList[i], 0);
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] ans = solution(id_list, report, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " "); // [2, 1, 1, 0]
        }
    }
}

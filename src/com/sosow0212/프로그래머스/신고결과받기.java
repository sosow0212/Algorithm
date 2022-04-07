package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 중복 제거
        HashSet<String> reportSet = new HashSet<>();
        for (String rep : report) {
            reportSet.add(rep);
        }

        // 2. notifyListHash 만들기
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for (String rep : reportSet) {
            int blankIndex = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIndex);
            String reported = rep.substring(blankIndex + 1);

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reported, null);
            if (reporterList == null) {
                reporterList = new ArrayList<>();
            }

            reporterList.add(reporter);
            notifyListHash.put(reported, reporterList);
        }


        // 3. notifyListHash 기반으로 reporterHash 만들기
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHash.values()) {
            if (notifyList.size() >= k)
                for (String reporter : notifyList)
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
        }


        // 4. reporterHash 기반으로 answer 배열 채우기
        for(int i=0; i< id_list.length; i++) {
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        신고결과받기 sol = new 신고결과받기();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = sol.solution(id_list, report, k);


        // [2,1,1.0];
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}
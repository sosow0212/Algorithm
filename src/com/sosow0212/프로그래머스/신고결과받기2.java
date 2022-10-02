package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기2 {
    static public int[] solution(String[] idList, String[] report, int k) {
        int[] answer = new int[idList.length];
        HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));

        for (String reportInfo : reportSet) {
            String reporter = reportInfo.split(" ")[0];  // 신고 한 사람
            String reported = reportInfo.split(" ")[1];  // 신고 당한 사람
            reporterInfoMap.putIfAbsent(reporter, new HashSet<String>() {{
                add(reported);
            }});
            reporterInfoMap.get(reporter).add(reported);
            reportedCountInfoMap.put(reported, reportedCountInfoMap.getOrDefault(reported, 0) + 1);
        }

        for (String reported : reportedCountInfoMap.keySet()) {
            int reportedCount = reportedCountInfoMap.get(reported);
            if (reportedCount >= k) {
                // 메일 발송 대상
                for (int i = 0; i < idList.length; i++) {
                    if (reporterInfoMap.containsKey(idList[i]) && reporterInfoMap.get(idList[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
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

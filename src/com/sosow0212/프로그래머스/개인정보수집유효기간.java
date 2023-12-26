package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 개인정보수집유효기간 {
    
    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        // 0. today의 날을 일자로 환산
        String[] todayDateInfo = today.split("\\.");
        int dateCountOfToday = getDate(todayDateInfo);

        // 1. 약관을 map에 저장한다.
        HashMap<String, Integer> typeOfTerms = new HashMap<>();
        for (String term : terms) {
            typeOfTerms.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        // 2. 날을 모두 더해서 today와 비교한다.
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] privacyDateInfo = privacy[0].split("\\.");
            int termMonthOfPrivacy = typeOfTerms.get(privacy[1]);
            int dateCountOfPrivacy = getDate(privacyDateInfo);
            if (isDestroyed(dateCountOfToday, dateCountOfPrivacy, termMonthOfPrivacy)) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    private static boolean isDestroyed(int dateCountOfToday, int dateCountOfPrivacy, int termMonthOfPrivacy) {
        if (dateCountOfToday >= getDateWithTerm(dateCountOfPrivacy, termMonthOfPrivacy)) {
            return true;
        }
        return false;
    }

    private static int getDate(String[] dateInfo) {
        int dateOfYear = Integer.parseInt(dateInfo[0]) * 12 * 28;
        int dateOfMonth = Integer.parseInt(dateInfo[1]) * 28;
        int dateOfDay = Integer.parseInt(dateInfo[2]);
        return dateOfYear + dateOfMonth + dateOfDay;
    }

    private static int getDateWithTerm(int dateCountOfPrivacy, int termMonthOfPrivacy) {
        return dateCountOfPrivacy + termMonthOfPrivacy * 28;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(solution(today, terms, privacies)); // 1, 3

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(solution(today2, terms2, privacies2)); // 1, 4, 5
    }
}

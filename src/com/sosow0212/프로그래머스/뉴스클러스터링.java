package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {
    static public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        List<String> union = new ArrayList<>(); // 합집합
        List<String> same = new ArrayList<>(); // 교집합


        // str1 의 문자열을 2개로 쪼개고 str1List 에 넣기
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (a >= 'A' && b <= 'Z' && b >= 'A' && b <= 'Z') {
                str1List.add(Character.toString(a) + Character.toString(b));
            }
        }

        // str2 의 문자열을 2개로 쪼개고 str2List 에 넣기
        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if (a >= 'A' && a <= 'Z' && b >= 'A' && b <= 'Z') {
                str2List.add(Character.toString(a) + Character.toString(b));
            }
        }

        // str1을 기준으로 str2가 str1에 속하면 지우고, 교집합에 추가하고, 합집합에 str1을 넣는다.
        for(String s1 : str1List) {
            if(str2List.remove(s1)) {
                same.add(s1);
            }
            union.add(s1);
        }

        // str2를 합집합에 넣는다. (위에서 교집합이 될만한 부분은 이미 제거 했으므로, str2를 union에 넣기만 하면 합집합이 됨)
        for(String s2 : str2List) {
            union.add(s2);
        }

        System.out.println(str1List);
        System.out.println(str2List);
        System.out.println(union);
        System.out.println(same);

        // 공집합인 경우 1, 공집합이 아니라면 자카드 유사도를 answer 에 저장
        double answer = (union.size() == 0) ? 1 : (double) same.size() / (double) union.size();
        return (int) (answer * 65536);
    }

    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12")); // 16384
    }
}

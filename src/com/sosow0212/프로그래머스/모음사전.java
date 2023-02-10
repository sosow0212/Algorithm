package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 모음사전 {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static List<String> ans = new ArrayList<>();

    public static int solution(String word) {
        int answer = 0;
        int index = 1;

        for (int i = 1; i <= 5; i++) {
            dfs(0, "", i);
        }

        Collections.sort(ans);

        for (String tmp : ans) {
            if (tmp.equals(word)) {
                answer = index;
                break;
            }
            index++;
        }
        return answer;
    }

    public static void dfs(int depth, String tmp, int len) {
        if (depth == len) {
            ans.add(tmp);
            return;
        }
        for (int i = 0; i < 5; i++) {
            dfs(depth + 1, tmp + arr[i], len);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }
}

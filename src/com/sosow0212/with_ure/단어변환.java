package com.sosow0212.with_ure;

import java.util.Arrays;
import java.util.List;

public class 단어변환 {

    static int answer;
    static List<String> wordsList;
    static boolean[] visited;

    public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;

        wordsList = Arrays.asList(words);

        if (!wordsList.contains(target)) {
            return 0;
        }

        for (int i = 0; i < words.length; i++) {
            if (canChange(begin, wordsList.get(i))) {
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1, wordsList.get(i), target);
            }
        }

        return answer;
    }

    public static void dfs(int index, String now, String target) {
        if (now.equals(target)) {
            answer = Math.min(index, answer);
            return;
        }

        for (int i = 0; i < wordsList.size(); i++) {
            if (!visited[i] && canChange(now, wordsList.get(i))) {
                visited[i] = true;
                dfs(index + 1, wordsList.get(i), target);
                visited[i] = false;
            }
        }
    }

    private static boolean canChange(String begin, String target) {
        int notEqualsSize = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                notEqualsSize++;
            }
        }

        return notEqualsSize == 1;
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", words)); // 4

        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution("hit", "cog", words2)); // 0
    }
}

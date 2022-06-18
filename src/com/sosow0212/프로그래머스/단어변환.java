package com.sosow0212.프로그래머스;

public class 단어변환 {

    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(visited[i])
                continue;

            int k = 0;
            for(int j=0; j<begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    k ++;
                }
            }

            if(k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        단어변환 sol = new 단어변환();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(sol.solution(begin, target, words));
    }
}

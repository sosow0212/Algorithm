package com.sosow0212.프로그래머스다시;

public class 스킬트리 {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String s : skill_trees) {
            StringBuilder rep = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (skill.contains(Character.toString(c))) {
                    rep.append(c);
                }
            }

            if (skill.startsWith(rep.toString())) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "CBD";
        String[] t = {"BACDE", "CBADF", "AECB", "BDA"};

        // 2
        System.out.println(solution(s, t));
    }
}

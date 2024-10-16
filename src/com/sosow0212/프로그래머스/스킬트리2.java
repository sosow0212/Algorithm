package com.sosow0212.프로그래머스;

public class 스킬트리2 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i];
            StringBuilder res = new StringBuilder();

            for (int j = 0; j < tree.length(); j++) {
                char now = tree.charAt(j);
                if (skill.contains(String.valueOf(now))) {
                    res.append(now);
                }
            }

            skill_trees[i] = res.toString();
        }

        for (String skillTree : skill_trees) {
            if (skill.startsWith(skillTree)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        스킬트리2 sol = new 스킬트리2();

        System.out.println(sol.solution(
                "CBD",
                new String[]{"BACDE", "CBADF", "AECB", "BDA"}
        ));
    }
}

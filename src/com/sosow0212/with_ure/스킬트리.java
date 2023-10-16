package com.sosow0212.with_ure;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<String> filteredSkillTree = new ArrayList<>();
        List<Character> skillWords = new ArrayList<>();

        for (char c : skill.toCharArray()) {
            skillWords.add(c);
        }

        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (char c : skillTree.toCharArray()) {
                if (skillWords.contains(c)) {
                    sb.append(c);
                }
            }

            filteredSkillTree.add(sb.toString());
        }

        for (String s : filteredSkillTree) {
            if (skill.startsWith(s)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        // 2
        System.out.println(solution(skill, skill_trees));
    }
}

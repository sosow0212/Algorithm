package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 스킬트리 {
    static public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        List<String> treeList = new ArrayList<>();
        List<Character> skillWord = new ArrayList<>();

        for (int i = 0; i < skill.length(); i++) {
            skillWord.add(skill.charAt(i));
        }

        for (String skill_tree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < skill_tree.length(); i++) {
                if (skillWord.contains(skill_tree.charAt(i))) {
                    sb.append(skill_tree.charAt(i));
                }
            }
            treeList.add(sb.toString());
        }

        List<String> compareList = new ArrayList<>();
        for (int i = 0; i < treeList.size(); i++) {
            char[] charArr = treeList.get(i).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < charArr.length; j++) {
                int idx = skill.indexOf(charArr[j]);
                sb.append(String.valueOf(idx));
            }
            compareList.add(sb.toString());
        }

        for (int i = 0; i < compareList.size(); i++) {
            String str = compareList.get(i);
            for (int j = 0; j < str.length(); j++) {
                if (j != str.charAt(j) - '0') {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees)); // 2
    }
}

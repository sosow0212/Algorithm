package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class 튜플 {
    public List<Integer> solution(String s) {
        List<List<String>> list = new ArrayList<>();

        // 문자열 파싱
        String[] split = s.replace("{", "").split("}");
        for (String sp : split) {
            if (sp.charAt(0) == ',') {
                list.add(Arrays.stream(sp.substring(1).split(",")).collect(Collectors.toList()));
                continue;
            }
            list.add(Arrays.stream(sp.split(",")).collect(Collectors.toList()));
        }

        list.sort((a, b) -> Integer.compare(a.size(), b.size()));

        List<Integer> answers = new ArrayList<>();
        answers.add(Integer.valueOf(list.get(0).get(0)));

        for (int i = 1; i < list.size(); i++) {
            List<String> now = new ArrayList<>(list.get(i));
            List<String> before = new ArrayList<>(list.get(i - 1));

            for (String s1 : before) {
                now.remove(s1);
            }

            answers.add(Integer.valueOf(now.get(0)));
        }

        return answers;
    }
}

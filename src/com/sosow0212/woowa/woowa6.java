package com.sosow0212.woowa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class woowa6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        System.out.println(solution(forms));
    }

    static final int FORM_EMAIL = 0;
    static final int FORM_NICKNAME = 1;
    private static List<String> answer = new ArrayList<>();
    private static List<Set<String>> partsOfNicknameList = new ArrayList<>();
    private static Map<String, Integer> nicknameAndCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        for (List<String> form : forms) {
            Set<String> partsOfNickname = partsOfNickname(form.get(FORM_NICKNAME));
            partsOfNicknameList.add(partsOfNickname);

            for (String part : partsOfNickname) {
                nicknameAndCountMap.put(part, nicknameAndCountMap.getOrDefault(part, 0) + 1);
            }
        }

        for (int i = 0; i < partsOfNicknameList.size(); i++) {
            Set<String> parts = partsOfNicknameList.get(i);
            for (String part : parts) {
                if (nicknameAndCountMap.get(part) > 1) {
                    answer.add(forms.get(i).get(FORM_EMAIL));
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static Set<String> partsOfNickname(String nickname) {
        Set<String> separatedNickname = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            separatedNickname.add(nickname.substring(i, i + 2));
        }
        return separatedNickname;
    }
}

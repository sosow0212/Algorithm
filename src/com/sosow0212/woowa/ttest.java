package com.sosow0212.woowa;

import java.util.*;

public class ttest {
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


    private static final int FORM_EMAIL = 0;
    private static final int FORM_NICKNAME = 1;
    private static List<String> answer = new ArrayList<>();
    private static List<Set<String>> partitionsList = new ArrayList<>();
    private static Map<String, Integer> nicknameAndCount = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        setupData(forms);
        getAnswerFromPartitionsOfNickname(forms);
        System.out.println(partitionsList);
        return answer;
    }

    // 1. 해시맵에서 빈도수가 1 이상인 애들의 이메일값을 answer에 넣는다.
    public static void getAnswerFromPartitionsOfNickname(List<List<String>> forms) {
        for (int i = 0; i < partitionsList.size(); i++) {
            // hashmap.get("제이") == 3
            // [[제이, 이엠], [제이, 이슨], [워니], [제이, 엠제], [이제, 제엠]]
            Set<String> parts = partitionsList.get(i); // [[제이, 이엠]
            for (String part : parts) { // 제이 -> 이엠
                if (nicknameAndCount.get(part) > 1) {
                    answer.add(forms.get(i).get(FORM_EMAIL));
                }
            }
        }
        Collections.sort(answer);
    }

    // 1. 사용자별 이름을 2개씩 끊은 걸 Set로 만들고, 그걸 partitionsList에 넣는다.
    // 2. set를 바탕으로, 해시맵을 채운다.
    public static void setupData(List<List<String>> forms) {
        for (List<String> form : forms) {
            Set<String> partsOfNickname = getPartitions(form.get(1));
            partitionsList.add(partsOfNickname);
            for (String part : partsOfNickname) {
                nicknameAndCount.put(part, nicknameAndCount.getOrDefault(part, 0) + 1);
            }
        }

    }

    // 1. 닉네임을 기준으로 2글자씩 끊어서 Set에 넣고, Set를 반환해준다.
    public static Set<String> getPartitions(String nickname) {
        Set<String> partitions = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            partitions.add(nickname.substring(i, i + 2));
        }

        return partitions;
    }
}


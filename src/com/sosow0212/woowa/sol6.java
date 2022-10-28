//package onboarding;
//
//import java.util.*;
//
//public class Problem6 {
//    static final int FORM_EMAIL = 0;
//    static final int FORM_NICKNAME = 1;
//
//    static List<String> answer = new ArrayList<>();
//    static List<Set<String>> partsOfNicknameList = new ArrayList<>();
//    static Map<String, Integer> nicknameAndCountMap = new HashMap<>();
//
//    public static List<String> solution(List<List<String>> forms) {
//
//        setupData(forms);
//        getAnswer(forms);
//        Collections.sort(answer);
//
//        return answer;
//    }
//
//
//    // 닉네임 파트리스트를 하나씩 꺼내서, 1보다 크다면 answer에 이메일 추가
//    public static void getAnswer(List<List<String>> forms) {
//        for (int i = 0; i < partsOfNicknameList.size(); i++) {
//            if (partsOfNicknameList.get(i).stream().anyMatch(part -> nicknameAndCountMap.get(part) > 1)) {
//                answer.add(forms.get(i).get(FORM_EMAIL));
//            }
//        }
//    }
//
//    // forms에서 닉네임을 하나씩 꺼내서 분해한 후에, <set>parts 를 닉네임 리스트에 넣는다. 그리고 nicknameAndCountMap에 넣는다.
//    public static void setupData(List<List<String>> forms) {
//        forms.stream()
//                .map(form -> nicknameDecomposition(form.get(FORM_NICKNAME)))
//                .forEach(parts -> {
//                    partsOfNicknameList.add(parts);
//                    parts.forEach(part -> nicknameAndCountMap.put(part, nicknameAndCountMap.getOrDefault(part, 0) + 1));
//                });
//    }
//
//    // 닉네임을 2글자씩 분해
//    public static Set<String> nicknameDecomposition(String nickname) {
//        Set<String> separatedNickname = new HashSet<>();
//        for (int i = 0; i < nickname.length() - 1; i++) {
//            separatedNickname.add(nickname.substring(i, i + 2));
//        }
//        return separatedNickname;
//    }
//}

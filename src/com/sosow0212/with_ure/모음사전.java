package com.sosow0212.with_ure;

import java.util.HashSet;
import java.util.Set;

public class 모음사전 {

    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static Set<String> set;
    static int answer;

    public static int solution(String word) {
        answer = 0;
        set = new HashSet<>();

        permutation(0, "", word);
//        System.out.println(set);
        return answer;
    }

    static void permutation(int index, String sum, String word) {
        if (index > 5) {
            return;
        }

        if (!sum.equals("")) {
            set.add(sum);
            if (sum.equals(word)) {
                answer = set.size();
                return;
            }
        }

        for (int i = 0; i < arr.length; i++){
            permutation(index + 1, sum + arr[i], word);
        }
    }

    public static void main(String[] args) {

        System.out.println(solution("AAAAE")); // 6
        System.out.println(solution("AAAE")); // 10
        System.out.println(solution("I")); // 1563
        System.out.println(solution("EIO")); // 1189
    }
}

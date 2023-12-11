package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class 불량사용자 {

    List<String> user_id;
    String[] banned_id;
    List<String>[] ids;
    boolean[] visitedBanned;
    boolean[] visitedUser;
    Set<List<String>> combinations;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        this.user_id = new ArrayList<>(List.of(user_id));
        this.banned_id = banned_id;
        this.ids = new ArrayList[banned_id.length];
        this.visitedBanned = new boolean[banned_id.length];
        this.visitedUser = new boolean[user_id.length];
        this.combinations = new LinkedHashSet<>();

        for (int i = 0; i < banned_id.length; i++) {
            ids[i] = new ArrayList<>();
        }

        for (int i = 0; i < banned_id.length; i++) {
            String ban = banned_id[i];
            int lengthOfBannedId = ban.length();

            for (int j = 0; j < user_id.length; j++) {
                String user = user_id[j];

                if (user.length() == lengthOfBannedId) {
                    int count = 0;

                    for (int k = 0; k < user.length(); k++) {
                        if (user.charAt(k) == ban.charAt(k) || ban.charAt(k) == '*') {
                            count++;
                        }
                    }

                    if (count == lengthOfBannedId) {
                        ids[i].add(user);
                    }
                }
            }

        }

        permutation(0, new ArrayList<>());

        return combinations.size();
    }

    void permutation(int index, List<String> sum) {
        if (index == banned_id.length) {
            List<String> sortedSum = new ArrayList<>(sum);
            Collections.sort(sortedSum);
            combinations.add(sortedSum);
            return;
        }

        List<String> suspects = ids[index];

        for (int j = 0; j < suspects.size(); j++) {
            String suspect = suspects.get(j);

            if (!visitedUser[user_id.indexOf(suspect)] && !visitedBanned[index]) {
                visitedBanned[index] = true;
                visitedUser[user_id.indexOf(suspect)] = true;
                sum.add(suspect);
                permutation(index + 1, sum);
                sum.remove(suspect);
                visitedUser[user_id.indexOf(suspect)] = false;
                visitedBanned[index] = false;
            }
        }
    }

    public static void main(String[] args) {
        불량사용자 sol = new 불량사용자();

        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};
        // 2
        System.out.println(sol.solution(user_id1, banned_id1));

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};
        // 2
        System.out.println(sol.solution(user_id2, banned_id2));

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
        // 3
        System.out.println(sol.solution(user_id3, banned_id3));
    }
}

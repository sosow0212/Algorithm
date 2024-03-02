package com.sosow0212.프로그래머스다시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 여행경로 {

    static boolean[] visited;
    static List<String> answer;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            String[] now = tickets[i];

            if (now[0].equals("ICN")) {
                visited[i] = true;
                permutation(1, now[1], now[0] + "," + now[1], tickets);
                visited[i] = false;
            }
        }

        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    static void permutation(int index, String before, String routes, String[][] tickets) {
        if (index == tickets.length) {
            answer.add(routes);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] now = tickets[i];

            if (visited[i] || !before.equals(now[0])) {
                continue;
            }

            visited[i] = true;
            permutation(index + 1, now[1], routes + "," + now[1], tickets);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        System.out.println(Arrays.stream(solution(tickets1)).toList());

        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(Arrays.stream(solution(tickets2)).toList());

        String[][] tickets3 = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}};
//        System.out.println(Arrays.stream(solution(tickets3)).toList());
    }
}

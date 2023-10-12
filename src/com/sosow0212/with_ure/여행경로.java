package com.sosow0212.with_ure;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 여행경로 {

    static List<String> answers;
    static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        answers = new LinkedList<>();
        visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String startPoint = ticket[0];
            String endPoint = ticket[1];

            if (startPoint.equals("ICN")) {
                visited = new boolean[tickets.length];
                visited[i] = true;
                dfs(1, endPoint, "ICN " + endPoint, tickets);
            }
        }

        Collections.sort(answers);
        String answer = answers.get(0);
        return answer.split(" ");
    }

    static void dfs(int index, String start, String route, String[][] tickets) {
        if (index == tickets.length) {
            answers.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(index + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        // ["ICN", "JFK", "HND", "IAD"]
        System.out.println(Arrays.toString(solution(tickets)));

//         ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        System.out.println(Arrays.toString(solution(tickets2)));
    }
}

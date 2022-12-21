package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
    private static boolean[] visited; // 방문한지 안한지를 체크하는 visited 배열
    private static List<String> result = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        // 1. 변수 세팅
        visited = new boolean[tickets.length];

        // 2. 완전탐색 및 정렬
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(result);

        // 3. 정답 출력
        String[] answer = result.get(0).split(" ");
        return answer;
    }

    public static void dfs(int idx, String start, String route, String[][] tickets) {
        // 1. 탈출 조건 (비행기 티켓을 모두 사용한 경우)
        if (idx == tickets.length) {
            result.add(route);
            return;
        }

        // 2. 백트래킹 알고리즘 사용
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.stream(solution(tickets1)).toList());

        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(Arrays.stream(solution(tickets2)).toList());

        String[][] tickets3 = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}};
        System.out.println(Arrays.stream(solution(tickets3)).toList());
    }
}

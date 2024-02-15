package com.sosow0212.프로그래머스다시;

public class 타켓넘버_2 {

    static int answer;

    public static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(0, 0, numbers, target);

        return answer;
    }

    static void dfs(int index, int sum, int[] numbers, int target) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        dfs(index + 1, sum + numbers[index], numbers, target);
        dfs(index + 1, sum - numbers[index], numbers, target);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

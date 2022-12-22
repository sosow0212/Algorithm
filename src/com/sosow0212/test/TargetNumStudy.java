package com.sosow0212.test;

public class TargetNumStudy {
    private static int answer = 0;

    static public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    static private void dfs(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(idx + 1, sum + numbers[idx], numbers, target);
        dfs(idx + 1, sum - numbers[idx], numbers, target);

    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target)); // 5
    }
}

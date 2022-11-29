package com.sosow0212.프로그래머스;

public class 타겟넘버3 {
    int[] numbers;
    int target;
    int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) {
                answer ++;
            }
            return;
        }
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);
    }

    public static void main(String[] args) {
        타겟넘버3 sol = new 타겟넘버3();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }
}

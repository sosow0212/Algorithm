package com.sosow0212.프로그래머스;

class dfs타겟넘버 {
    int[] numbers;
    int target;
    int answer;

    void dfs (int index, int sum) {
        // 1. 탈출 조건
        if(index == numbers.length) {
            if(sum == target) answer ++;
            return;
        }

        // 2. 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;


        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        dfs타겟넘버 sol = new dfs타겟넘버();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));

    }
}
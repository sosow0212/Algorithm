package com.sosow0212.프로그래머스다시;

public class 타겟넘버 {

    // 다시 확인하기, 다른 방법??
    static int target; 
    static int[] numbers;
    static int answer;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.answer = 0;

        permutation(0, 0);

        return answer;
    }

    private static void permutation(int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        permutation(index + 1, sum + numbers[index]);
        permutation(index + 1, sum - numbers[index]);
    }

    public static void main(String[] args) {
        타겟넘버 sol = new 타겟넘버();

        // 5
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

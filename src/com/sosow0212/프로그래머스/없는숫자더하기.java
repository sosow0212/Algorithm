package com.sosow0212.프로그래머스;

class 없는숫자더하기 {
    static public int solution(int[] numbers) {
        int answer = 0;

        int[] arr = {1,1,1,1,1,1,1,1,1,1};

        for(int i=0; i<numbers.length; i++) {
            arr[numbers[i]] --;
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }
}
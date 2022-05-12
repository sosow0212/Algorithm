package com.sosow0212.프로그래머스;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for(int i=1; i<=total; i++) {
            int row = i;
            int col = total / row;

            if(row > col) {
                continue;
            }

            if((col-2) * (row-2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        카펫 sol = new 카펫();
        int[] arr = sol.solution(10, 2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

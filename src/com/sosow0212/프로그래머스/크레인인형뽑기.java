package com.sosow0212.프로그래머스;

import java.util.Stack;

public class 크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        for (int i = 0; i < moves.length; i++) {
            // 처음 for문은 각각의 moves에 대한 처리를 해준다

            for (int j = 0; j < board.length; j++) {
                // 두번째 for문은 board에서 0이 아닌 인형을 찾기위해서 돌려준다.

                if (board[j][moves[i] - 1] != 0) {
                    // 인형이 있는 경우

                    if (stack.peek() == board[j][moves[i] - 1]) {
                        // 인형이 있고, 그게 스택에 있는 인형과 같은 경우
                        stack.pop();
                        answer += 2;
                    } else {
                        // 인형이 있지만, 스택에 있는 인형과 다른 경우
                        stack.push(board[j][moves[i] - 1]);
                    }

                    // 스택에 집어 넣었거나, 카운트 해줬으니 원래 인형이 있던 자리는 0으로 설정 해준다.
                    board[j][moves[i] - 1] = 0;

                    // 탐색하면서 처음으로 만나는 인형에 대해서만 처리를 해줘야하니 break를 걸어줘야한다.
                    // 안 걸면, for가 계속 돌아서 맨 처음 만나는 인형뿐만 아니라, 그 다음 인형까지 처리할 수 있다.
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        크레인인형뽑기 sol = new 크레인인형뽑기();
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(sol.solution(board, moves));
    }
}

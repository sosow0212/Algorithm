package com.sosow0212.백준;

import java.util.Scanner;

public class q17478 {
    static String underBar = "";
    static String sArr[];

    public static void recursive(int num) {
        String temp = underBar;

        /*
         * 재귀 종료 조건 - Base Case
         *  __ ... __"재귀함수가 뭔가요?"
         *  __ ... __"재귀함수는 자기 자신을 호출하는 함수라네"
         *  __ ... __라고 답변하였지.
         */
        if (num == 0) {
            System.out.println(temp + sArr[0]);
            System.out.println(temp + sArr[4]);
            System.out.println(temp + sArr[5]);
            return;
        }

        for (int i = 0; i < 4; i++)    // 재귀호출하면서 반복되는 네개의 문장
            System.out.println(temp + sArr[i]);

        underBar += "____";    // 호출될 때 마다 밑줄이 2개씩 증가.
        recursive(num - 1);

        // 재귀가 종료되고   라고 답변하였지. <-- 부분
        System.out.println(temp + sArr[5]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        sArr = new String[6];
        for (int i = 0; i < sArr.length; i++)
            sArr[i] = "";
        sArr[0] = "\"재귀함수가 뭔가요?\"";
        sArr[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        sArr[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        sArr[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        sArr[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
        sArr[5] = "라고 답변하였지.";
        recursive(N);
        scan.close();
    }

}
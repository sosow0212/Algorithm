package com.sosow0212.woowa;

import java.util.List;

class woowa1 {

    public static void main(String[] args) {
        System.out.println(solution(List.of(99, 102), List.of(211, 212)));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 유효성 검사 (오른쪽 = 왼쪽 + 1이 아닌 경우 // 왼쪽 홀수 아닌 경우)
        if (checkException(pobi) || checkException(crong)) {
            return -1;
        }

        // 점수 구하기
        int maxValueOfPobi = getMaxValueOfPlayer(pobi);
        int maxValueOfCrong = getMaxValueOfPlayer(crong);

        // 값 비교 검사
        answer = getResult(maxValueOfPobi, maxValueOfCrong);

        return answer;
    }

    public static int getResult(int scoreOfPobi, int scoreOfCrong) {
        if (scoreOfPobi == scoreOfCrong) {
            return 0;
        }

        return scoreOfPobi > scoreOfCrong ? 1 : 2;
    }

    public static boolean checkException(List<Integer> pages) {
        boolean isException = false;

        if (pages.get(0) + 1 != pages.get(1) || pages.get(0) % 2 == 0) {
            isException = true;
        }

        return isException;
    }

    public static int getMaxValueOfPlayer(List<Integer> pages) {
        // [왼쪽 페이지 합, 오른쪽 페이지 합, 왼쪽 페이지 곱, 오른쪽 페이지 곱]
        int leftMaxValue = getMaxValueOfPage(pages.get(0));
        int rightMaxValue = getMaxValueOfPage(pages.get(1));

        int maxValueOfPages = leftMaxValue >= rightMaxValue ? leftMaxValue : rightMaxValue;
        return maxValueOfPages;
    }

    public static int getMaxValueOfPage(int leftPage) {
        String strOfLeftPage = String.valueOf(leftPage);

        int max = 0;
        int sum = 0;
        int mul = 1;

        for (int i = 0; i < strOfLeftPage.length(); i++) {
            int temp = strOfLeftPage.charAt(i) - '0';
            sum += temp;
            mul *= temp;
        }

        max = sum >= mul ? sum : mul;
        return max;
    }

}
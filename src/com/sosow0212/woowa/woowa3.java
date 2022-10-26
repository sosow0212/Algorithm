package com.sosow0212.woowa;

public class woowa3 {

    public static void main(String[] args) {
        System.out.println(solution(33));
    }

    public static int solution(int number) {
        int answer = 0;

        answer = getCount(number);

        return answer;
    }

    public static int getCount(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            String numberStr = makeStringNumber(i);
            count += getClapCountByStrNumber(numberStr);
        }

        return count;
    }

    public static int getClapCountByStrNumber(String numberStr) {
        int count = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            char c = numberStr.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }

        return count;
    }

    public static String makeStringNumber(int number) {
        return String.valueOf(number);
    }
}

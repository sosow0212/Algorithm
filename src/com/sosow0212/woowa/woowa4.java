package com.sosow0212.woowa;

public class woowa4 {

    public static void main(String[] args) {
        System.out.println(solution("I love you")); // R olev blf
    }

    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(getCharacterByLowerCase(c));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(getCharacterByUpperCase(c));
            } else if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(c);
            }

        }

        answer = sb.toString();

        return answer;
    }

    public static char getCharacterByLowerCase(char alphabet) {
        char newChar = 'a';

        if(alphabet <= 'm') {
            newChar = (char) (109 + (110 - alphabet));
        }

        if(alphabet >= 'n' && alphabet <= 'z') {
            newChar = (char) (110 - (alphabet - 109));
        }

        return newChar;
    }

    public static char getCharacterByUpperCase(char alphabet) {
        char newChar = 'a';

        if(alphabet <= 'M') {
            newChar = (char) (77 + (78 - alphabet));
        }

        if(alphabet >= 'N' && alphabet <= 'Z') {
            newChar = (char) (78 - (alphabet - 77));
        }

        return newChar;
    }


}

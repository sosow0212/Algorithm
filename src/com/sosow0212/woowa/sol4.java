//package onboarding;
//
//public class Problem4 {
//
//    public static String solution(String word) {
//        String answer = getAnswer(word);
//        return answer;
//    }
//
//    public static String getAnswer(String word) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            sb.append(getFrogWord(c));
//        }
//        return sb.toString();
//    }
//
//    public static char getFrogWord(char c) {
//        if (!Character.isAlphabetic(c))
//            return c;
//        if (Character.isUpperCase(c)) {
//            return (char) ('A' + ('Z' - c));
//        } else {
//            return (char) ('a' + ('z' - c));
//        }
//    }
//
//    public static char getCharacterByLowerCase(char alphabet) {
//        char newChar = 'a';
//        if (alphabet <= 'm') {
//            newChar = (char) (109 + (110 - alphabet));
//        }
//        if (alphabet >= 'n' && alphabet <= 'z') {
//            newChar = (char) (110 - (alphabet - 109));
//        }
//        return newChar;
//    }
//
//    public static char getCharacterByUpperCase(char alphabet) {
//        char newChar = 'a';
//        if (alphabet <= 'M') {
//            newChar = (char) (77 + (78 - alphabet));
//        }
//        if (alphabet >= 'N' && alphabet <= 'Z') {
//            newChar = (char) (78 - (alphabet - 77));
//        }
//        return newChar;
//    }
//
//}

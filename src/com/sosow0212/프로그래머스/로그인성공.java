package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 로그인성공 {
    public static final String SUCCESS = "login";
    public static final String WRONG = "wrong pw";
    public static final String FAIL = "fail";

    static public String solution(String[] id_pw, String[][] db) {
        HashMap<String, String> map = new HashMap<>();

        Arrays.stream(db).map(i -> map.put(i[0], i[1])).collect(Collectors.toList());

        if (map.containsKey(id_pw[0])) {
            if (map.get(id_pw[0]).equals(id_pw[1])) {
                return SUCCESS;
            }
            return WRONG;
        } else {
            return FAIL;
        }
    }

    public static void main(String[] args) {
        String[] id_pw = {"meosseugi", "1234"};
        String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
        System.out.println(solution(id_pw, db)); // login
    }
}

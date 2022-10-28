package com.sosow0212.woowa;

import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        System.out.println(partsOfNickname("leejaeyoon"));
    }

    public static Set<String> partsOfNickname(String nickname) {
        Set<String> separatedNickname = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            System.out.println(nickname.substring(i, i+2));
            separatedNickname.add(nickname.substring(i, i + 2));
        }
        return separatedNickname;
    }
}

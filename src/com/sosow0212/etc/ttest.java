package com.sosow0212.etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ttest {
    private static final String ONLY_NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$+";

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        int a = 3;
        System.out.println(list.contains(a));
    }
}
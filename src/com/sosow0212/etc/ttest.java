package com.sosow0212.etc;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ttest {
    private static final String ONLY_NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$+";

    public static void main(String[] args) {
        int pay = 8000;
        int earn = 5015;
        double yield = ((double)earn/pay) * 100;
        double yield2 = Math.round(yield);
        System.out.println(yield);
        System.out.println(yield2);
    }
}
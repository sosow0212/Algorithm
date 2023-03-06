package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q2870 {

    private static final Pattern pattern = Pattern.compile("[\\d]+");
    private static int n;
    private static List<String> numbers = new ArrayList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        initData();
        initMatch();
        getAnswer();
    }

    private static void initData() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    private static void initMatch() throws IOException {
        while (n-- > 0) {
            String input = br.readLine();
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String num = matcher.group().replaceAll("^0+", "");
                numbers.add(num.length() == 0 ? "0" : num);
            }
        }
    }

    private static void getAnswer() {
        numbers.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}

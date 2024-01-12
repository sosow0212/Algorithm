package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class q29731 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = Map.of(
                "Never gonna give you up", 1,
                "Never gonna let you down", 1,
                "Never gonna run around and desert you", 1,
                "Never gonna make you cry", 1,
                "Never gonna say goodbye", 1,
                "Never gonna tell a lie and hurt you", 1,
                "Never gonna stop", 1
        );

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (!map.containsKey(str)) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}

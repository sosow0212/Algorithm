package study;

import java.util.*;
import java.io.*;

public class q15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        System.out.println((a+b)*(a-b));
    }
}
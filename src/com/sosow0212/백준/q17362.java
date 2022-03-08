package com.example.shoppingmall.web.dto;

import java.io.*;
import java.util.*;

public class q17362 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(finger(Integer.parseInt(br.readLine())) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int finger(int a){
        a = a - 1;
        a = a % 8;
        if(a == 0) return 1;
        else if(a == 1 || a == 7) return 2;
        else if(a == 2 || a == 6) return 3;
        else if(a == 3 || a == 5) return 4;
        else return 5;
    }
}
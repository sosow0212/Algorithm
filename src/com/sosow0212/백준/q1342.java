package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q1342{
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine().toCharArray();
        isC=new boolean[s.length];
        cntLuck=0;
        lucky(0, ' ');
        System.out.println(cntLuck);
    }

    static char[] s;
    static boolean[] isC;
    static int cntLuck;

    static void lucky(int cnt, char prev) {
        if(cnt==s.length) {
            cntLuck++;
            return;
        }
        int bitMask=0;
        for (int i = 0; i < s.length; i++) {
            if(!isC[i] && s[i]!=prev && ( (bitMask&1<<(s[i]-'a')) == 0)) {
                //not used + not same with prev
                isC[i]=true;
                bitMask|=1<<(s[i]-'a');
                lucky(cnt+1, s[i]);
                isC[i]=false;
            }
        }
    }

    static int pint(String s) {
        return Integer.parseInt(s);
    }
}

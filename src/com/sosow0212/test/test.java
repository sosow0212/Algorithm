package com.sosow0212.test;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> hashMap = new HashMap<String, String>();

        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], " ");
        }

        for (String p : phone_book) {
            for (int i = 0; i < p.length(); i++) {
                if(hashMap.containsKey(p.substring(0,i))) {
                    return false;
                }
            }
        }

        return answer;
    }

    private class Hashmap<T, T1> {
    }
}

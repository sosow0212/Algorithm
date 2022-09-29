package com.sosow0212.test;

import java.lang.reflect.Member;

public class test123 {
    public static void main(String[] args) {
        member m = new member("yoony", 10);
        String str = "yoon";

        for(int i=0; i<100; i++) {
            str += "y";
        }
        // new String ==> 100번 호출;
        // 마지막 결과값을 위해, 99개의 스트링 공간 낭비 GC행 (메모리 누수);
        // pool heap

        // heap -> Integer, Long, String
        // pool -> int, long, float


        System.out.println(m.name.equals(str)); // true
        System.out.println(m.name == str); // false
    }
}


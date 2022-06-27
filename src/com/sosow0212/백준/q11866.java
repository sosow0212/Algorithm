package com.sosow0212.백준;

import java.util.*;

public class q11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();
        String ans = "<";

        int count = 0;

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            count ++;
            if(count == k) {
                ans += queue.poll() + ", ";
                count = 0;
            } else {
                queue.add(queue.poll());
            }
        }

        ans = ans.substring(0, ans.length() - 2);
        ans += ">";

        System.out.println(ans);
    }
}

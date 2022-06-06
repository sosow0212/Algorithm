package com.sosow0212.백준;

import java.util.*;

public class q2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> ans = new ArrayList<>();
        int last;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(true) {
            if(queue.size() == 1) {
                last = queue.poll();
                break;
            }
            ans.add(queue.poll());

            int temp = queue.poll();
            queue.add(temp);
        }

        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
//
        System.out.println(last);
    }
}

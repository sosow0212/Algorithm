package study;

import java.util.Scanner;

public class q2167 {
 
    public static int n, m, oper, sum = 0;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
 
        int[][] arr = new int[n + 1][m + 1];
 
        for (int k = 1; k <= n; k++) {
 
            for (int l = 1; l <= m; l++) {
 
                arr[k][l] = sc.nextInt();
 
            }
        }
 
        oper = sc.nextInt();
        for (int k = 0; k < oper; k++) {
            sum = 0;
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int i2 = i; i2 <= x; i2++) {
                for (int j2 = j; j2 <= y; j2++) {
                    sum += arr[i2][j2];
                }
            }
            System.out.println(sum);
 
        }
 
    
 
    }
 
}
 
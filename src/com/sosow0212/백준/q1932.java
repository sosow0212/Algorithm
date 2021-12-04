package com.sosow0212.백준;

import java.util.Scanner;

public class q1932 {
 
	static int[][] arr;
	static Integer[][] dp;
	static int N;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
 
		arr = new int[N][N];
		dp = new Integer[N][N];
 
        
		// �迭 �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		// ���� ������ ���� ������ DP�� ������ �࿡�� �Ȱ��� ����
		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = arr[N - 1][i];
		}
 
		System.out.println(find(0, 0));
 
	}
 
	
	static int find(int depth, int idx) {
		// ������ ���� ��� ���� ��ġ�� dp�� ��ȯ
		if(depth == N - 1) return dp[depth][idx];
 
		// Ž������ �ʾҴ� ���� ��� ���� ���� ���� �� ��
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
		}
		return dp[depth][idx];
 
	}
}
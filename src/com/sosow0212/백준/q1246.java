package study;

import java.io.*;
import java.util.*;

public class q1246 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken()) ,M = Integer.parseInt(st.nextToken()), max = 0, point = 0; 
		int arr[] = new int[M], sum[] = new int[M];
		
		for(int i = 0; i < M; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		for (int i =0; i <M; i++) {
			if(M>N) { // ����� �ް� �������� ���� ���
				if(i<(M-N+1)) // �ް��� ��� �Ǹ��ϴ� ���
					sum[i] = arr[i]*N; 
				else // �ް� �Ϻθ� �Ǹ��ϴ� ���
					sum[i] = arr[i]* (M-i);
			} // �ް��� ��� ������ ���� ���
			else
				sum[i] = arr[i] * (M-i);
		}
		
		max = sum[0];
		for(int i = 1; i < M; i++) {
			if (sum[i] > max) {
				max = sum[i];
				point = i;
			}
		}
		
		System.out.println(arr[point]+" "+max);
		br.close();
	}
}
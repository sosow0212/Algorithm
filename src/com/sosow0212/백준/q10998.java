package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q10998 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int start = 0;
		int end = len - 1;
		int result = 1; // 팰린드롬 여부 
		
		while(start <= end) {
			char startChar = str.charAt(start);
			char endChar = str.charAt(end);
			
			if(startChar != endChar) {
				result = 0;
				break;
			}
			
			start++;
			end--;
		}
		
		System.out.print(result);
	}
}
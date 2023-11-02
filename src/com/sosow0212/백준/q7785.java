package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class q7785 {

	static int N;
	public static void main(String[] args) {

		HashMap<String, String> hash=new HashMap<>();
		Scanner in=new Scanner(System.in);
		N=in.nextInt();
		String[][] map=new String[N][2];
		
		for(int i=0;i<N;i++) {
			map[i][0]=in.next();
			map[i][1]=in.next();
			hash.put(map[i][0],map[i][1]);
		}
		
		ArrayList<String> arr=new ArrayList<>();
		
		for(String str: hash.keySet())
			if(hash.get(str).equals("enter")) arr.add(str);
		
		//대소문자 구분o + 내림 차순
		Collections.sort(arr, Collections.reverseOrder());
		
		//대소문자 구분x + 내림차순
		//Collections.sort(arr, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		for(String str:arr)
			System.out.println(str);
	}
}

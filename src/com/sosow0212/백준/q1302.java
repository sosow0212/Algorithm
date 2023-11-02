package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class q1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			
			if(map.containsKey(str))
				map.put(str, map.get(str)+1);
			else
				map.put(str, 1);
		}
		
		int max = 0;
		String str = "";
		for(String key: map.keySet()) {
			if(max<map.get(key)) {
				max = map.get(key);
				str = key;
			}
			else if(max == map.get(key)) {
				if(key.compareTo(str)<0) {
					str = key;
				}
			}
		}
		
		System.out.println(str);

	}

}
 
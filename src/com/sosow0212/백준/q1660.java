import java.util.*;
import java.io.*;

public class q1660 {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk;
    	n = stoi(br.readLine());

    	List<Integer> arr = new ArrayList<>();

    	arr.add(1);
    	int val = 3;
    	int idx = 3;
    	while(arr.get(arr.size() - 1) + val <= 300000) {
    		arr.add(arr.get(arr.size() - 1) + val);
    		val += idx;
    		idx++;
    	}
    	arr.add(300001);

    	int[] dp = new int[n + 1];

    	Arrays.fill(dp, Integer.MAX_VALUE);

    	dp[0] = 0;
    	int j = 0;
    	for(int i = 0; i <= n; i++) {
    		j = 0;
    		while(arr.get(j) <= i) {
    			dp[i] = Math.min(dp[i], dp[i - arr.get(j)] + 1);
    			j++;
    		}
    	}

    	System.out.println(dp[n]);
    	br.close();
	}

	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}

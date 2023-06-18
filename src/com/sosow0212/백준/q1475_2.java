import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1475 {
  
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int[] numSet = new int[10];
		for(char c : N.toCharArray()) {
			int num = c - '0';
			if(num==9) { 
				num = 6;
			}
			numSet[num]++;
		}
        
		numSet[6] = numSet[6]/2 + numSet[6]%2;
		
		Arrays.sort(numSet); 
		System.out.println(numSet[9]);
	}
}

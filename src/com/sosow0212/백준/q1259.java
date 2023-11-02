import java.util.Arrays;
import java.util.Scanner;

public class q1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		while (true) {
			s = sc.next();
			if (s.equals("0"))
				break;
			char [] chars = new char[s.length()];
			for (int i=0;i<s.length();i++) {
				chars[i] = s.charAt(i);
			}
			
			boolean flag = true;
			for (int i=0;i<chars.length-1-i;i++) {
				if (chars[i]!=chars[chars.length-1-i]) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}

}
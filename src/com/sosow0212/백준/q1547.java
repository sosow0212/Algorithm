import java.util.Scanner;

public class q1547 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int M = scan.nextInt();	// 컵 위치를 바꾼 횟수
		int cup = 1;	// 컵 번호
		for(int i=0; i<M; i++) {
			int X = scan.nextInt();
			int Y = scan.nextInt();
			
			if(cup == X)	
				cup = Y;
			else if(cup == Y)
				cup = X;
		}
		
		System.out.println(cup);
		scan.close();
	}

}

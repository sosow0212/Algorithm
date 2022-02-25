import java.util.Scanner;

public class q1080 {
	static int[][] matA;
	static int[][] matB;
	static int N , M;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		matA = new int [N][M];
		matB = new int [N][M];
		
		
		// matA input
		for ( int i=0; i<N; i++) {
			String str = sc.next();
			for ( int j=0; j<M; j++) {
				matA[i][j] = str.charAt(j);
			}
		}
		
		for ( int i=0; i<N; i++) {
			String str = sc.next();
			for ( int j=0; j<M; j++) {
				matB[i][j] = str.charAt(j);
			}
		}
		
		if ( N < 3 || M < 3) {
			if ( IsSame(matA,matB) ) {
				answer = 0;
			}
			else {
				answer = -1;
			}
		}
		else {
			Solution();
		}
		
		if( !IsSame(matA, matB)) {
			answer = -1;
		}
		
		System.out.println(answer);
	}

	private static void Solution() {

		for( int i=0; i<N-2 ; i++) {
			for ( int j=0; j<M-2 ;j ++) {
				if ( matA[i][j] != matB[i][j]) {
					filp(i,j);
					answer ++;
				}
			}
		}
	}

	private static void filp(int cr, int cn) {
		
		for ( int i=cr; i< cr+3; i++) {
			for ( int j=cn; j<cn+3; j++) {
				matA[i][j] = matA[i][j] ^ 1 ; // 뒤집기
			}
		}
		
	}

	private static boolean IsSame(int[][] matA2, int[][] matB2) {
		for ( int i=0; i<N; i++) {
			for ( int j=0; j<M;j ++){
				if ( matA2[i][j] != matB2[i][j] ) return false; 
			}
		}
		
		return true;
	}
}

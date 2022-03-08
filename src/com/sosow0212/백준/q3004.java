import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cut = sc.nextInt();
        int piece = 1, a = 1;
        for(int i = 0; i < cut; i++){
            if(i%2 != 0){
                a += 1;
            }
            piece += a;
        }
        System.out.println(piece);
    }
}

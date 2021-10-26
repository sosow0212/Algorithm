import java.util.Scanner;

public class q1003 {
    static int[] num0=new int[41];
    static int[] num1=new int[41];
    static int k=0;

    static void fibonacci(int n){
        if(n==0){
           num0[k]++;
            return;
        } else if(n==1){
            num1[k]++;
            return;
        }else{
            fibonacci(n-1);
            fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int num;

       for(int i=0; i<n; i++) {
           num=sc.nextInt();

            fibonacci(num);
            System.out.println(num0[i] + " " + num1[i]);
           k++;
        }
    }
}
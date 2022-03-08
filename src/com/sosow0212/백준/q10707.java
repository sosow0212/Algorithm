import java.util.Scanner;

public class q10707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), p = sc.nextInt();
        int x, y;
        x = a * p;
        if(c < p)
            y = b + ((p - c) * d);
        else
            y = b;
        System.out.println(Math.min(x, y));
    }
}

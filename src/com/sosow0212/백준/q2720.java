import java.util.Scanner;
import java.util.ArrayList;

class q2720 {

  public static int t, c;
  public static int[] coin = {25, 10, 5, 1};
  public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    for(int i = 0; i < t; i++)
      result.add(new ArrayList<>());

    for(int tc = 0; tc < t; tc++){
      c = sc.nextInt();

      for(int i = 0; i < coin.length; i++){
        int cnt = c / coin[i];
        result.get(tc).add(cnt);
        c %= coin[i];
      }
    }

    for(int i = 0; i < t; i++){
      for(int j = 0; j < coin.length; j++)
        System.out.print(result.get(i).get(j) + " ");
      System.out.println();
    }
      
  }
}

import java.util.*;

class q2138{
    static int n;

    static boolean[] arr1,arr2,goal;

    static int cnt1=1;
    static int cnt2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        arr1 = new boolean[n];
        arr2 = new boolean[n];
        goal = new boolean[n];

        char[] temp;
        temp = sc.next().toCharArray();
        for(int i=0;i<n;i++){
            arr1[i] = temp[i]=='1';
            arr2[i] = temp[i]=='1';
        }
        temp = sc.next().toCharArray();

        for(int i=0;i<n;i++){
            goal[i] = temp[i]=='1';
        }



        swithOn(arr1,0);

        for(int i=1;i<n;i++){
            if(arr1[i-1] != goal[i-1]) {
                swithOn(arr1,i);
                cnt1++;
            }
            if(arr2[i-1] != goal[i-1]) {
                cnt2++;
                swithOn(arr2,i);
            }
        }

        int ret = checkAndReturn();
        System.out.println(ret==Integer.MAX_VALUE?-1:ret);


    }


    static void swithOn(boolean[] arr, int idx){
        for(int i=idx-1;i<=idx+1;i++){
            if(i>=0 && i<n){
                arr[i] = !arr[i];
            }
        }
    }

    static int checkAndReturn(){
        int ret = Integer.MAX_VALUE;
        boolean ok1 = true;
        boolean ok2 = true;

        for(int i=0;i<n;i++){
            if(arr1[i]!=goal[i]){
                ok1 = false;
            }
            if(arr2[i]!=goal[i]){
                ok2 = false;
            }
        }

        if(ok1) ret = cnt1;
        if(ok2) ret = Math.min(ret,cnt2);

        return ret;
    }
}

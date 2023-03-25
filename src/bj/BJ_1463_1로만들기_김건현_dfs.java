package bj;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1463_1로만들기_김건현_dfs {

    static int[] dp;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        System.out.println(makeToOne(n));
    }
    //그냥 하면 시간초과
    static int makeToOne(int n){
        if(n==1) return 0;
        int min = makeToOne(n-1);
        if(n%3==0)
            min = Math.min(min,makeToOne(n/3));
        if(n%2==0) {
            min = Math.min(min,makeToOne(n/2));
        }
        return dp[n] = min+1;
    }
}

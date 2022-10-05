package com.kim.backjoon;

import java.util.Scanner;

//dp
public class BJ_1463_1로만들기_김건현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1]; //1부터 n까지 사용
        dp[1]=0;
        if(n>1)  dp[2]=1;
        int min;
        //각수에 대해 2로나누어떨어지는지 3으로 나누어떨어지는지 여부를 체크하고 최솟값+1을 저장
        for (int i = 3; i <= n; i++) {
            min = dp[i-1];
            if(i%3==0)
                min = Math.min(dp[i/3],min);
            if(i%2==0)
                min = Math.min(dp[i/2],min);
            dp[i] = min+1;
        }
        System.out.println(dp[n]);

    }
}

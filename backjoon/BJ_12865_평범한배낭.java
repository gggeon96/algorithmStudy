package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] value = new int[N+1];
        int[] weight = new int[N+1];
        int[][] dp = new int[N+1][K+1]; //첫번째 열과 행을 0으로 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        //dp로직
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(j>=weight[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= K; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }


        System.out.println(dp[N][K]);




    }
}

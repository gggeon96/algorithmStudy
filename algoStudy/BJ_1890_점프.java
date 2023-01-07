package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1890_점프 {
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[0][0]>0) dp[0][0] = 1;

        //로직. 칸의수만큼 오른쪽, 아래쪽으로 이동 후 해당좌표의 dp에 +1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int hop = map[i][j];
                if(hop==0) continue;
                if(dp[i][j]>0){
                    if (j + hop < N) dp[i][j + hop] += dp[i][j]; //여기에서 오래걸렸다. 경로니까 +1을 해버렸는데 지금까지 온경로를 더해줘야하니 +dp[i][j]를 해줘야한다.
                    if (i + hop < N) dp[i + hop][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}

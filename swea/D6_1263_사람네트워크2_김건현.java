package com.kim.swea;

import java.io.*;
import java.util.StringTokenizer;

public class D6_1263_사람네트워크2_김건현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int tmp;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmp = Integer.parseInt(st.nextToken());
                    if(i==j) continue;
                    if(tmp==0){
                        map[i][j] = 1000000;
                    }else{
                        map[i][j] = tmp;
                    }
                }
            }

            //플로이드
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(i==j) continue;
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }


            //제일 작은거 찾기
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum =0;
                for (int j = 0; j < N; j++) {
                    sum+=map[i][j];
                }
                if(sum<min) {
                    min = sum;
                }
            }

            bw.write("#"+t+" "+min+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

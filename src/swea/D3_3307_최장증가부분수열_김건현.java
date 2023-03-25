package swea;

import java.io.*;
import java.util.StringTokenizer;

public class D3_3307_최장증가부분수열_김건현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            int MAX = Integer.MIN_VALUE;

            //입력받기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //로직
            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        MAX = Math.max(MAX, dp[i]);
                    }
                }
            }

            bw.write("#"+t+" "+MAX+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

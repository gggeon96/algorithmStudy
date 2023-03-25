package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2240_자두나무_김건현 {
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] inputs = new int[T + 1];
        int[][] dp = new int[W + 1][T + 1];
        int MAX = Integer.MIN_VALUE;
        for (int i = 1; i <= T; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        for (int time = 1; time <= T; time++) {
            dp[0][time] = inputs[time] == 1 ? (dp[0][time - 1] + 1) : (dp[0][time - 1]);
        }

        //logic
        for (int time = 1; time <= T; time++) {
            for (int row = 1; row <= W; row++) {
                if (inputs[time] == 1) {
                    if (row % 2 == 0) { //짝수행이 늘어남
                        dp[row][time] = Math.max(dp[row - 1][time - 1], dp[row][time - 1] + 1);
                    } else {
                        dp[row][time] = Math.max(dp[row - 1][time - 1] + 1, dp[row][time - 1]);
                    }
                } else { //홀수행이 +1받음
                    if (row % 2 == 0) {
                        dp[row][time] = Math.max(dp[row - 1][time - 1] + 1, dp[row][time - 1]);
                    } else {
                        dp[row][time] = Math.max(dp[row - 1][time - 1], dp[row][time - 1] + 1);
                    }
                }

            }
        }
        for (int row = 0; row <= W; row++) {
            MAX = Math.max(MAX, dp[row][T]);
        }
        System.out.println(MAX);


    }
}

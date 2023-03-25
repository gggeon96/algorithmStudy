package bj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_1010_다리놓기_김건현 {
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        dp = new int[30][30];
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int t = 0; t < testCase; t++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            bw.write(String.valueOf(dp[m][n])+"\n");
        }

        bw.flush();
        bw.close();
			
		
		
	}

}

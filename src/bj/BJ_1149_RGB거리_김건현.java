package bj;

import java.io.*;
import java.util.Scanner;


public class BJ_1149_RGB거리_김건현 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp = new int[1001][3];
    static int[][] RGB;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RGB = new int[n][3];
        for(int i=0;i<n;i++){
            RGB[i][0] = sc.nextInt();
            RGB[i][1] = sc.nextInt();
            RGB[i][2] = sc.nextInt();
        }
        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        int k = 1;
        while(k<n){
            dp[k][0] = Math.min(RGB[k][0]+dp[k-1][1],RGB[k][0]+dp[k-1][2]);
            dp[k][1] = Math.min(RGB[k][1]+dp[k-1][0],RGB[k][1]+dp[k-1][2]);
            dp[k][2] = Math.min(RGB[k][2]+dp[k-1][0],RGB[k][2]+dp[k-1][1]);
            k++;
        }
        bw.write(Math.min(Math.min(dp[n-1][0], dp[n-1][1] ),dp[n-1][2] )+" ");
        bw.flush();
        bw.close();
    }
}

package algo;

import java.util.Scanner;

public class BJ_17070_파이프옮기기1_김건현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map  = new int[n][n];
		Point[][] dp = new Point[n][n];
		//초기화
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = new Point(0,0,0);
			}
		}
		dp[0][0].a = 1;
		dp[0][1].a = 1;
		
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.println(dp[i][j].a+"/"+dp[i][j].b+"/"+dp[i][j].c);
//			}
//		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=2;j<n;j++) {
				if(map[i][j] == 1) continue;
				//왼쪽 위
				if(i-1>=0&&j-1>=0&&map[i-1][j]!=1&&map[i][j-1]!=1) {
					dp[i][j].c = dp[i-1][j-1].a+dp[i-1][j-1].b+dp[i-1][j-1].c;
				}
				//왼쪽
				if(i>=0&&j-1>=0&&map[i][j-1]!=1) {
					dp[i][j].a = dp[i][j-1].a+ dp[i][j-1].c; 
				}
				
				if(i-1>=0&&j>=0&&map[i-1][j]!=1) {
					dp[i][j].b = dp[i-1][j].b+ dp[i-1][j].c; 
				}
			}
		}
		
		System.out.println(dp[n-1][n-1].a+dp[n-1][n-1].b+dp[n-1][n-1].c);
		
		
		
	}	
	
	static class Point {
		int a;
		int b;
		int c;
		public Point(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	}

}

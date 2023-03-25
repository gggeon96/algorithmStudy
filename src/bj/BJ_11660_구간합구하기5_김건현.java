package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1]; 
		int[][] dp = new int[N+1][N+1];
		int x1,y1,x2,y2;
		int sum = 0;
		for(int i=1;i<N+1;i++) { //초기화
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum+=arr[i][j];
				dp[i][j] = sum;
			}
		}
		
		
		for(int i=0;i<M;i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			//인덱스는 0부터 있으니까 -1씩해쥼!
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int row = x1;row<=x2;row++) {
				//y2까지의합에서 y1까지의 합을 빼고 y1을 더해준다. 그러면 닫힌구간[y1,y2]까지합ㅇ;됨
				sum += dp[row][y2]-dp[row][y1-1];
			}
			sb.append(sum+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}

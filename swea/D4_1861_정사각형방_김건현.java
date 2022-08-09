package day_0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_1861_정사각형방_김건현 {
	static int[] dx = {1,-1,0,0};//하 상 우 좌
	static int[] dy = {0,0,1,-1};
	static int N;
	static int[][] area;
	static int minNum;
	static int tmp;
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1;T>=t;t++) {
			minNum = 0;
			N = Integer.parseInt(br.readLine());
			area = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i,j,0,area[i][j]);
				}
			}
			//dfs(0,0,0);
			
			System.out.println("#"+t+" "+minNum+" "+max);
			
		}
		
	
		
	}
	static void dfs(int row,int col, int count,int startNum) {
		System.out.println("DFS called"+row+" "+col+" "+count);
		if(count>max) {
			max = count;
			minNum = startNum;
		}
		boolean flag = true;
		for(int i=0;i<4;i++) {
			//유효범위 안이면
			if(row+dx[i]>=0&&row+dx[i]<N&&col+dy[i]>=0&&col+dy[i]<N) {
				//정확히 1더 크다면
				if((area[row+dx[i]][col+dx[i]])+1 == area[row][col]) {
					flag = false;
					dfs(row+dx[i],col+dx[i],count+1,startNum);
				}
			}
		}
		if(flag) return;
	}
	
}

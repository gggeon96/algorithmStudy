package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임_김건현 {
	static void dfs(int game,int scoreKyu,int scoreIn) {
		if(game == 9) {
			if(scoreKyu>scoreIn) kyuWin++;
			else if(scoreIn>scoreKyu) inWin++;
			else {}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(kyu[game]>in[i]) {
					dfs(game+1, scoreKyu+kyu[game]+in[i], scoreIn);
				}else  {
					dfs(game+1, scoreKyu, scoreIn+kyu[game]+in[i]);
				}
				visited[i] = false;
			}
		}
	}
	static int[] kyu;
	static int[] in;
	static int kyuWin;
	static int inWin;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int T=1;T<=TC;T++) {
			kyuWin = 0;
			inWin = 0;
			kyu = new int[9];
			in = new int[9];
			boolean[] check = new boolean[19];
			visited = new boolean[9];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				int num = Integer.parseInt(st.nextToken());
				kyu[i] = num;
				check[num] = true;
			}
			for(int i=1,idx = 0;i<19;i++) {
				if(!check[i]) {
					in[idx++] = i;
				}
			}
			dfs(0,0,0);
			
			System.out.println("#"+T+" "+kyuWin+" "+inWin);
			
		}
		
	}

}

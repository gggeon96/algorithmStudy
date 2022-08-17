package day_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15683_감시_김건현 {
	static int[][] map;
	static Cctv[] cctvs;
	static boolean visited[];
	static int size;
	static int N;
	static int M;
	static int[] dx= {-1,1,0,0}; //상하좌우
	static int[] dy= {0,0,-1,1};
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ArrayList<Cctv> cctvList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//cctv이면 cctvs배열에 저장
				if(map[i][j]>=1&&map[i][j]<=5) {
					cctvList.add(new Cctv(i,j,map[i][j]));
				}
			}
		}
		size = cctvList.size();
		visited = new boolean[size];
		cctvs = new Cctv[size];
		for(int i=0;i<size;i++) {
			cctvs[i] = cctvList.get(i);
		}
		search(0);
		System.out.println(MIN);
	}
	
	static void search(int count) {
		//모두 탐색하면
		if(count == size) {
			int sum = countArea();
			if(MIN>sum) MIN = sum;
			return;
		}
		int k= count;
			int[][] tmp = arrCopy(map);
			
			switch(cctvs[k].type) {
			case 1:
				up(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				down(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				left(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				right(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				break;
			case 2:
				//패턴두개 dx[0] or dx[2];
				up(cctvs[k]);
				down(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				left(cctvs[k]);
				right(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				break;
			case 3:
				up(cctvs[k]);
				left(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				up(cctvs[k]);
				right(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				down(cctvs[k]);
				left(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				down(cctvs[k]);
				right(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				break;
			case 4:
				left(cctvs[k]);
				right(cctvs[k]);
				down(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				left(cctvs[k]);
				right(cctvs[k]);
				up(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				up(cctvs[k]);
				right(cctvs[k]);
				down(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				
				left(cctvs[k]);
				up(cctvs[k]);
				down(cctvs[k]);
				search(count+1);
				map = arrCopy(tmp);
				break;
			case 5:
				left(cctvs[k]);
				right(cctvs[k]);
				up(cctvs[k]);
				down(cctvs[k]);
				search(count+1);
				break;
			}
	}
	static void up(Cctv cctv) {
		int row = cctv.row;
		int col = cctv.col;
		int dis = 1;
		while(true) {
			int rowTemp=row+dx[0]*(dis);
			int colTemp=col+dy[0]*(dis);
			dis++;
			if(rowTemp>=0&&rowTemp<N&&colTemp>=0&&colTemp<M) {
				if(map[rowTemp][colTemp]==6) break;
				if(map[rowTemp][colTemp]==0) map[rowTemp][colTemp] = 7;
			}
			else {
				break;				
				
			}
		}
	}
	
	static void down(Cctv cctv) {
		int row = cctv.row;
		int col = cctv.col;
		int dis = 1;
		while(true) {
			int rowTemp=row+dx[1]*(dis);
			int colTemp=col+dy[1]*(dis);
			dis++;
			if(rowTemp>=0&&rowTemp<N&&colTemp>=0&&colTemp<M) {
				if(map[rowTemp][colTemp]==6) break;
				if(map[rowTemp][colTemp]==0) map[rowTemp][colTemp] = 7;
			}
			else {
				break;				
				
			}
		}
	}
	
	static void right(Cctv cctv) {
		int row = cctv.row;
		int col = cctv.col;
		int dis = 1;
		while(true) {
			int rowTemp=row+dx[3]*(dis);
			int colTemp=col+dy[3]*(dis);
			dis++;
			if(rowTemp>=0&&rowTemp<N&&colTemp>=0&&colTemp<M) {
				if(map[rowTemp][colTemp]==6) break;
				if(map[rowTemp][colTemp]==0) map[rowTemp][colTemp] = 7;
			}
			else {
				break;				
				
			}
		}
	}
	
	static void left(Cctv cctv) {
		int row = cctv.row;
		int col = cctv.col;
		int dis = 1;
		while(true) {
			int rowTemp=row+dx[2]*(dis);
			int colTemp=col+dy[2]*(dis);
			dis++;
			if(rowTemp>=0&&rowTemp<N&&colTemp>=0&&colTemp<M) {
				if(map[rowTemp][colTemp]==6) break;
				if(map[rowTemp][colTemp]==0) map[rowTemp][colTemp] = 7;
			}
			else {
				break;				
				
			}
		}
	}
	
	static int countArea() {
		int count = 0;
		for(int i=0;i<N;i++) {
			for (int j = 0; j < M; j++) {
				//벽이거나 0이면 사각지대개수 ++
				if(map[i][j] == 0) count++; 
			}
		}
		return count;
	}
	
	static int[][] arrCopy(int[][] arr) {
		int[][] tmp = new int[N][M];
		for(int i = 0; i < N; i++){ // 반복문 + ArrayCopy
			System.arraycopy(arr[i], 0, tmp[i], 0, tmp[i].length);
		}
		return tmp;
	}
	
	static class Cctv{
		int row;
		int col;
		int type;
		public Cctv(int row, int col, int type) {
			super();
			this.row = row;
			this.col = col;
			this.type = type;
		}
		
	}
}

package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어_김건현 {
	static Shark shark;
	static int N;
	static int[][] area;
	static int SECONDS = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		//area 초기화
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(area[i][j] == 9) {
					shark = new Shark(i,j,2,0); //shark초기화
				}
			}
		}
		
		play();
//		System.out.println("play returned"); //test
		System.out.print(SECONDS);
	}
	static void play() {
//		System.out.println("play called"); //test
		while(true) {
			List<Fish> fishes = search();
			//먹을수 있는 물고기 리스트가 비어있으면, 현재까지의 초 반환
			if(fishes.size()==0) return; //종료조건
			Collections.sort(fishes);
//			System.out.println("fishes Returned"); //test
			Fish prey = fishes.get(0); //먹이가 될 물고기
//			System.out.println(prey.row+" "+prey.col); //test
			area[shark.row][shark.col] = 0;
			shark.row = prey.row;
			shark.col = prey.col;
			shark.count++;
			area[prey.row][prey.col] = 9;//먹이 먹었으니 없애주기
			if(shark.isLVUP()) shark.LVUP();
			SECONDS+=prey.dis;
		}
		
	}
	
	static class Shark{
		int row;
		int col;
		int size;
		int count;
		public Shark(int row, int col, int size, int count) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.count = count;
		}
		public boolean isLVUP() {
			if(size == count) {
				return true;
			}
			return false;
		}
		public void LVUP() {
			count = 0;
			size++;
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int row;
		int col;
		int size;
		int dis;
		public Fish(int row, int col, int size, int dis) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.dis = dis;
		}
		@Override
		public int compareTo(Fish o) {
			if(this.dis==o.dis) {
				if(this.row==o.row) {
					return this.col-o.col;
				}
				return this.row-o.row;
			}
			return this.dis-o.dis;
		}
	}
	
	static class Point{
		int row;
		int col;
		int dis;
		public Point(int row, int col,int dis) {
			super();
			this.row = row;
			this.col = col;
			this.dis = dis;
		}
	}
	//주변에 먹을 수 있는 물고기들을 찾아서 List로 반환
	static List<Fish> search(){
		int[] dx = {-1,1,0,0}; //상하좌우
		int[] dy = {0,0,-1,1};
		boolean[][] visited = new boolean[N][N];
		List<Fish> fishes = new ArrayList<>();
		Queue<Point> q= new LinkedList<>();
		q.offer(new Point(shark.row,shark.col,0)); // 현재 아기상어의위치를 큐에 넣음
		visited[shark.row][shark.col] = true; //방문체크
		
		//BFS
		while(!q.isEmpty()) {
			int size = q.size();
			//큐의 사이즈만큼 반복
			for(int i=0;i<size;i++) {
				//큐에서 하나 꺼내서
				Point point = q.poll();
				//4방향 탐색. 배열범위 안이면 넣음.
				for(int pos=0;pos<4;pos++) {
					int x = point.row+dx[pos];
					int y = point.col+dy[pos];
					//밟을 수 있고, 안가본 곳이라면
					if(stepAble(x,y) && !visited[x][y]) {
						if(edible(x,y)) {
							visited[x][y] = true;
							fishes.add(new Fish(x,y,area[x][y],point.dis+1));
						}
						else {
							visited[x][y] = true;
							//그냥 공백이면 지금까지 이동해온 거리 +1
							q.offer(new Point(x,y,point.dis+1));
						}
					}
				}
			}
			if(!fishes.isEmpty()) {
//				System.out.println("BFS break"); //test
				break;
			}
		}
		
		
		return fishes;
	}
	//배열의 범위안인지 체크
	static boolean moveAble(int row, int col) {
		if(row>=0&row<N&&col>=0&&col<N) return true;
		return false;
	}
	
	//먹을수 있는 칸인지.
	static boolean edible(int row,int col) {
		//아기상어의 크기가 더 크면 먹을 수 있음
		if(area[row][col] < shark.size && area[row][col]!=0) {
			return true;
		}
		return false;
	}
	
	//배열 범위안이고 밟을 수 있는 칸인지
	static boolean stepAble(int row,int col) {
		if(moveAble(row,col)) {
			if(area[row][col] <= shark.size) {
				return true;
			}
		}
		return false;
	}
}

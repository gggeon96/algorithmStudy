package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토_김건현 {
	static int[][] area;
	static boolean[][] visited;
	static int COL;
	static int ROW;
	static Queue<Tomato> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		COL = Integer.parseInt(st.nextToken());//열
		ROW = Integer.parseInt(st.nextToken()); //행
		q = new LinkedList<>();
		area = new int[ROW][COL];
		visited = new boolean[ROW][COL];
		
		//area 초기화
		for(int i=0;i<ROW;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<COL;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				//익은 토마토라면 큐에 넣고 방문체크
				if(area[i][j]==1) {
					q.offer(new Tomato(i, j));
					visited[i][j] = true;
				}
			}
		}
		System.out.println(BFS());
	}
	
	//배열 범위 안이면 true리턴
	static boolean isRange(int row,int col) {
		if(row>=0&& row<ROW && col>=0 && col<COL ) {
			return true;
		}
		return false;
	}
	
	//안익은 토마토가 있는지 체크
	static boolean isComplete() {
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				if(area[i][j]==0)
					return false;
			}
		}
		return true;
	}
	
	static int BFS() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int days = 0;
		if(isComplete()) return days;
		while(!q.isEmpty()) {
			int size = q.size(); //날짜 구분을 위해 size만큼만 반복
			for(int i=0;i<size;i++) {
				Tomato tomato = q.poll();
				
				//4방향 체크
				for(int j=0;j<4;j++) {
					//범위안이고 방문한적 없으면 큐에 넣기
					int x = tomato.row+dx[j];// 새로 가고자 할 좌표
					int y = tomato.col+dy[j];
					if(isRange(x,y) && !visited[x][y]&& area[x][y] ==0) {
						area[x][y] = 1; //익은 토마토로 바꿔주기
						visited[x][y] = true; //방문체크 후 
						q.offer(new Tomato(x,y)); //큐에넣기
					}
				}
			}
			days++; // 날짜증가
//			System.out.println("day =>"+days+" qsize=>"+q.size());
//			print();
			
			
		}
		
		//큐는 비었는데 0이 존재한다 -> -1 return
		if(!isComplete()) return -1;
		//정상 종료됐으면 days 리턴
		return days-1;
	}
	
	
	static class Tomato{
		int row;
		int col;
		public Tomato(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static void print() {
		for(int i=0;i<ROW;i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(area[i][j]+" ");
			}
			System.out.println();
		}
	}
}

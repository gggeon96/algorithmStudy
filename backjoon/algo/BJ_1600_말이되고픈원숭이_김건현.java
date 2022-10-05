package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1600_말이되고픈원숭이_김건현 {
	static int W;
	static int H;
	static int[] horseX={-2,-1,1,2,-2,-1,1,2};
	static int[] horseY={-1,-2,-2,-1,1,2,2,1};
	static int[] dx = {-1,1,0,0};//상하좌우
	static int[] dy = {0,0,-1,1};
	static int[][] map ;
	static int MIN = Integer.MAX_VALUE;
	static boolean[][][] check;
	static int K;
	//말이든 원숭이든 도착점은 1이 아니여야한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		check = new boolean[H][W][K+1];
		Queue<Movement> q = new LinkedList<>();
		Movement mv = new Movement(0,0,K,0);
		check[0][0][mv.horseKing] = true;
		q.offer(mv);
		
		while(!q.isEmpty()) {
			mv = q.poll();
			int row = mv.row;
			int col = mv.col;
			if(row==H-1 && col==W-1) {
				MIN = Math.min(MIN, mv.cnt);
			}
			//아직 말이 될수있다면
			if(mv.horseKing>0) {
				for(int dir=0;dir<8;dir++) {
					int nextRow = row+horseX[dir];
					int nextCol = col+horseY[dir];
					if(isRange(nextRow,nextCol)&&!isObstacle(nextRow,nextCol)&&!check[nextRow][nextCol][mv.horseKing-1]) {
						check[nextRow][nextCol][mv.horseKing-1] = true;
						q.offer(new Movement(nextRow, nextCol, mv.horseKing-1, mv.cnt+1));
					}
				}
			}
			for(int dir=0;dir<4;dir++) {
				int nextRow = row+dx[dir];
				int nextCol = col+dy[dir];
				if(isRange(nextRow,nextCol)&&!isObstacle(nextRow,nextCol)&&!check[nextRow][nextCol][mv.horseKing]) {
					check[nextRow][nextCol][mv.horseKing] = true;
					q.offer(new Movement(nextRow, nextCol, mv.horseKing, mv.cnt+1));
				}
			}
		}
		if(MIN==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(MIN);
		}
		
	}
	
	static boolean isRange(int row ,int col) {
		if(row>=0&&row<H&&col>=0&&col<W) 	{
			return true;
		}
		return false;
	}
	
	static boolean isObstacle(int row, int col) {
		if(map[row][col] == 1) return true;
		return false;
	}
	
	static boolean[][] copyArr(boolean[][] arr){
		boolean[][] result = new boolean[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}
	
	
	static class Movement{
		int row;
		int col;
		int horseKing; // 말이 될 수 있는 횟수
		int cnt;
		public Movement(int row, int col, int horseKing, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.horseKing = horseKing;
			this.cnt = cnt;
		}
	}
}

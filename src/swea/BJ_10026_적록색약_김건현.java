package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026_적록색약_김건현 {
	static char[][] area;
//	static char[][] area2;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new char[N][N];
		int totalA=0;
		int totalB = 0;
		for(int i= 0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				area[i][j] = str.charAt(j);
			}
		}
		totalA+=countChar('R');
		totalA+=countChar('G');
		totalA+=countChar('B');
		colorChange();
		
		totalB+=countChar('R');
		totalB+=countChar('B');
		System.out.print(totalA+" "+totalB);
	}
	
	
	//해당 알파벳에 해당하는 무리의개수리턴
	static int countChar(char c) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int count = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<Point> q= new LinkedList<>();
		
		//더이상 해당하는 문자가 없을 때 까지 반복
		while(true) {
			Point p = find(c,visited);
			if(p==null) {
				return count;
			}
			q.offer(p);
			visited[p.row][p.col] = true;
			count++;
			
			//연결된 곳 모두 BFS
			while(!q.isEmpty()) {
				p = q.poll();
				for(int pos=0;pos<4;pos++) {
					int x = p.row+dx[pos];
					int y = p.col+dy[pos];
					if(isRange(x,y) && !visited[x][y] && area[x][y] == c) {
						visited[x][y] = true;
						q.offer(new Point(x,y));
					}
				}
			}
		}
		
		
		
		
	}
	
	//해당 하는문자의 Point반환
	static Point find(char c,boolean[][] visited) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(area[i][j]==c&&!visited[i][j]) {
					return new Point(i,j);
				}
			}
		}
		return null;
	}
	
	//적록색약용 배열로 만들기 G-> R
	static void colorChange() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(area[i][j]=='G') area[i][j] = 'R';
			}
		}
	}
	
	
	
	//범위 안인지
	static boolean isRange(int row,int col) {
		if(row>=0&&row<N&&col>=0&&col<N) return true;
		return false;
	}
	
	static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

}

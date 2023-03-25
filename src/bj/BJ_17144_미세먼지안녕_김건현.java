package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕_김건현 {
	static int R;
	static int C;
	static int T;
	static int puriUp;
	static int puriDown;
	static Point[][] area;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		area = new Point[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				int dust = Integer.parseInt(st.nextToken());
				if(dust == -1) {
					puriUp = i-1;
					puriDown = i;
				}
				area[i][j] = new Point(i,j,dust,0);
			}
		}
//		System.out.println("처음 init");
//		print();
		
		for(int i=0;i<T;i++) {
			spread();
//			System.out.println("spread");
//			print();
			clean();
		}
		
//		System.out.println("AFTER");
//		print();
		System.out.println(getSum());
		
		
		
	}
	
	
	
	//Point클래스
	static class Point{
		int row;
		int col;
		int dust; //미세먼지의 양
		int bucket; //확산된것이 일단 여기로 들어옴
		public Point(int row, int col, int dust, int bucket) {
			super();
			this.row = row;
			this.col = col;
			this.dust = dust;
			this.bucket = bucket;
		}
	}
	
	//바람불기
	static void clean() {
		//위쪽 바람 shift 열은 0고정
		//아래로부는바람
		for(int i=puriUp-1;i>0;i--) 
			area[i][0].dust = area[i-1][0].dust;
		//왼쪽으로 부는 바람
		for(int j=0;j<C-1;j++)
			area[0][j].dust = area[0][j+1].dust;
		//위로 부는 바람 열은 C-1고정
		for(int i=0;i<puriUp;i++)
			area[i][C-1].dust = area[i+1][C-1].dust;
		//오른쪽으로 부는 바람 i=puriUp고정
		for(int j=C-1;j>1;j--)
			area[puriUp][j].dust = area[puriUp][j-1].dust;
		area[puriUp][1].dust = 0;
		
		
		//공기청정기 아래쪽
		//위로 부는 바람 열은 C-1고정
		for(int i=puriDown+1;i<R-1;i++) 
			area[i][0].dust = area[i+1][0].dust;
		//오른쪽으로 부는 바람 i=puriDown고정
		for(int j=0;j<C-1;j++)
			area[R-1][j].dust = area[R-1][j+1].dust;
		//아래로 부는 바람 열은 C-1고정
		for(int i=R-1;i>puriDown;i--)
			area[i][C-1].dust = area[i-1][C-1].dust;
		//오른쪽으로 부는 바람 i=puriDown고정
		for(int j=C-1;j>1;j--)
			area[puriDown][j].dust = area[puriDown][j-1].dust;
		area[puriDown][1].dust = 0;
	}
	
	//확산 모든배열에대해 탐색하면서 퍼지는건 bucket에 넣고 턴이 끝나면 dust에 담아주는 식으로.
	static void spread() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//해당 범위의 미세먼지가 퍼질수있다면. 이때 공기청정기는 -1이라 알아서 걸러짐
				if(area[i][j].dust/5 > 0 ) {
					int count = 0; //몇방향으로 퍼지는지
					int dust = area[i][j].dust/5; //퍼질 양
					//4방향 탐색
					for(int pos = 0;pos<4;pos++) {
						int nextX = i+dx[pos]; //다음에 탐방할 곳
						int nextY = j+dy[pos];
						//범위 안이고 공기청정기가 아니라면
						if(isRange(nextX, nextY)) {
							count++; //범위늘리고
							area[nextX][nextY].bucket+=dust;//합치기 전에 임시로bucket에 넣기
						}
					}
					area[i][j].dust -= count*dust; //퍼진만큼 뺴주기
				}
			}
		}
		bucketToDust(); //초가 끝나면 늘려주기
	}
	//bucket에 있는 미세먼지 dust로
	static void bucketToDust() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				area[i][j].dust += area[i][j].bucket; //bucket을 dust와 합친다
				area[i][j].bucket = 0; //비워주기
			}
		}
	}
	
	//남아있는 미세먼지 양 클래스
	static int getSum() {
		int sum = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(isRange(i,j)) {
					sum+=area[i][j].dust;
				}
			}
		}
		return sum;
	}
	
	//배열의 범위체크 AND 공기청정기에 닿지 않는지 까지 체크
	static boolean isRange(int row, int col) {
		//범위안이고
		if(row>=0&&row<R&&col>=0&&col<C) {
			//공기청정기가 아니라면
			if( !(area[row][col].dust== -1) ) {
				return true;
			}
		}
		return false;
	}
	
//	static void print() {
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(area[i][j].dust+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("--------------------------");
//	}
	
	
}

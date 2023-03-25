package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4_김건현 {
	static int N;
	static int M;
	static int MIN = Integer.MAX_VALUE;
	static boolean[]  visited;
	static RCS[] rcs;
	static int[][] arr;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		rcs = new RCS[K];
		visited = new boolean[K];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//순열 진행할 배열
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rcs[i] = new RCS(r,c,s);
		}
		DFS(0,arr.clone());
		System.out.println(MIN);
	}
	
	static void DFS(int count,int[][]arr) {
		if(count == K) {
			int tmp = calcMin(arr);
			if(tmp<MIN) MIN = tmp;
		}
		for(int i=0; i<K;i++) {
			if(!visited[i]) {//방문한 적이 없다면.
				int[][] arrClone = new int[N][M];
				copy(arr,arrClone);
				int[][] arrProto = new int[N][M];
				copy(arrClone,arrProto);			
				visited[i] = true; //방문체크하고 해당 rcs명령을 수행
				rotate(rcs[i].r,rcs[i].c,rcs[i].s,arrClone); 
//				System.out.println("#i = "+i);
//				print(arrClone);
				DFS(count+1,arrClone);
				visited[i] = false;
				copy(arrProto,arrClone);	
			}
		}
		return;
	}
	static void copy(int[][] proto,int[][] copy) {
		for(int i=0;i<proto.length;i++) {
			for(int j= 0;j<proto[i].length;j++) {
				copy[i][j] = proto[i][j];
			}
		}
	}
	
	static class RCS{
		int r;
		int c;
		int s;
		public RCS() {
			super();
		}
		public RCS(int r, int c, int s) {
			super();
			this.r = r-1;
			this.c = c-1;
			this.s = s;
		}
		
	}
	
	//배열의 값 계산
	static int calcMin(int[][] arr) {
		int min = Integer.MAX_VALUE;
		int sum;
		for(int[] x:arr) {
			sum=0;
			for(int y:x) {
				sum+=y;
			}
			if(sum<min) min = sum;
		}
		
		return min;
	}
	
	static void print(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j= 0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void rotate(int row,int col,int s,int[][] arr) {
		int startCol = col-s;
		int endCol = col+s;
		int startRow = row-s;
		int endRow = row+s;
		int tmp = 0;
		while(startRow<endRow&&startCol<endCol) {
			int prev = 0;
			int i = startRow, j = startCol;
			while(true) {
				//테두리의 제일 윗줄
				if(i==startRow) {
					//제일 윗줄이면서 제일 왼쪽요소
					if(j==startCol) {
						prev = arr[i][j]; //다음행 첫번째 열에 넣어줌 A[1][1]을 저장해서 A[2][1]에
						arr[i][j] = arr[i+1][j];
					}else if(j==endCol) {
						tmp = arr[i][j];
						arr[i][j] = prev;
						prev = tmp;
						i++;
						j=startCol;
						continue;
					}
					else { //제일 윗줄이면서 제일 왼쪽거는 아닌것들
						tmp = arr[i][j];
						arr[i][j] = prev;
						prev = tmp;
					}
					j++;
				}
				//테두리의 제일 아랫줄
				else if(i==endRow){
					if(j==endCol) {
						arr[i][j] = prev;
						break;
					}
					arr[i][j] = arr[i][j+1];
					j++;
				}
				
				//테두리의 왼쪽 모서리 이면서 제일아랫줄아님
				else if(j==startCol) {
					arr[i][j] = arr[i+1][j];
					j = endCol;
					
				}
				//제일 윗줄은 아니면서 제일 왼쪽줄인경우
				else if(j==endCol) {
					tmp = arr[i][j];
					arr[i][j] = prev;
					prev = tmp;
					j=startCol;
					i++;
				}
				
			}
			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}
		
		
	}
}
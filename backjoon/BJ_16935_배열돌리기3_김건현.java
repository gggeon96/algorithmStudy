package day_0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3_김건현 {
	static int[][] arr;
	static int[][] result;
	static int N;
	static int M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int t=0;t<R;t++) {
			
			int insert = Integer.parseInt(st.nextToken());
			switch(insert) {
			case 1:
				result = new int[N][M];
				do1();
				arr = result;
				break;
			case 2:
				result = new int[N][M];
				do2();
				arr = result;
				break;
			case 3:
				result = new int[M][N];
				do3();
				int tmp = M;
				M= N;
				N=tmp;
				arr = result;
				break;
			case 4:
				result = new int[M][N];
				do4();
				int tmp2 = M;
				M= N;
				N=tmp2;
				arr = result;
				break;
			case 5:
				result = new int[N][M];
				do5();
				arr = result;
				break;
			case 6:
				result = new int[N][M];
				do6();
				arr = result;
				break;
			}
			
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void do1() throws IOException{
		int ROW = arr.length;
		int COL = arr[0].length;
		for(int i=ROW-1,a=0;i>=0;i--,a++) {
			for(int j=0,b=0;j<COL;j++,b++) {
//				bw.write(arr[i][j]+" ");
				result[a][b] = arr[i][j];
			}
		}
	}
	static void do2() throws IOException{
		int ROW = arr.length;
		int COL = arr[0].length;
		for(int i=0,a=0;i<ROW;i++,a++) {
			for(int j=COL-1,b=0;j>=0;j--,b++) {
				result[a][b] = arr[i][j];
			}
		}
	}
	static void do3() throws IOException{
		int ROW = arr.length;
		int COL = arr[0].length;
		for(int i=0,b=ROW-1;i<ROW;i++,b--) {
			for(int j=0, a=0;j<COL;j++,a++) {
				result[a][b] = arr[i][j];
			}
		}
	}
	
	static void do4() throws IOException{
		int ROW = arr.length;
		int COL = arr[0].length;
		for(int i=0,b=0;i<ROW;i++,b++) {
			for(int j=0, a=COL-1;j<COL;j++,a--) {
				result[a][b] = arr[i][j];
			}
		}
	}
	
	static void do5() throws IOException{
			int ROW = arr.length;
			int COL = arr[0].length;
			for(int i=ROW/2,a=0; i<ROW; i++,a++) { //4번그룹
				for(int j=0,b=0; j<COL/2; j++,b++) {
					result[a][b] = arr[i][j];
				}
			}
			for(int i=0,a=0; i<ROW/2; i++,a++) { //1번그룹
				for(int j=0,b=COL/2; j<COL/2; j++,b++) {
					result[a][b] = arr[i][j];
				}
			}
			for(int i=ROW/2,a=ROW/2;i<ROW;i++,a++) { //3번그룹
				for(int j=COL/2,b=0;j<COL;j++,b++) {
					result[a][b] = arr[i][j];
				}
			}
			for(int i=0,a=ROW/2;i<ROW/2;i++,a++) { //2번그룹
				for(int j=COL/2,b=COL/2;j<COL;j++,b++) {
					result[a][b] = arr[i][j];
				}
			}
		
	}
	
	static void do6() throws IOException{
		int ROW = arr.length;
		int COL = arr[0].length;
		for(int i=0,a=0;i<ROW/2;i++,a++) { //2번그룹
			for(int j=COL/2,b=0;j<COL;j++,b++) {
				result[a][b] = arr[i][j];
			}
		}
		for(int i=ROW/2,a=0;i<ROW;i++,a++) { //3번그룹
			for(int j=COL/2,b=COL/2;j<COL;j++,b++) {
				result[a][b] = arr[i][j];
			}
		}
		for(int i=0,a=ROW/2; i<ROW/2; i++,a++) { //1번그룹
			for(int j=0,b=0; j<COL/2; j++,b++) {
				result[a][b] = arr[i][j];
			}
		}
		for(int i=ROW/2,a=ROW/2; i<ROW; i++,a++) { //4번그룹
			for(int j=0,b=COL/2; j<COL/2; j++,b++) {
				result[a][b] = arr[i][j];
			}
		}
	
		
		
}
}

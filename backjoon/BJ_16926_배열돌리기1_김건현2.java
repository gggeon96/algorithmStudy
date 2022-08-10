package day_0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1_김건현2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		//초기화
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M ;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//로직
		for(int r = 0;r<R;r++) {
			int startCol = 0;
			int endCol = M-1;
			int startRow = 0;
			int endRow = N-1;
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
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}


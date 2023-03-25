package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4012_요리사_김건현 {
	static boolean[] selected;
	static int[][] arr;
	static int N;
	static int foodA = 0;
	static int foodB = 0;
	static int foodSum;
	static int MIN;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;T>=t;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			selected = new boolean[N];
			foodA = 0;
			foodB = 0;
			MIN = Integer.MAX_VALUE;
			//초기화
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] =  Integer.parseInt(st.nextToken());
				}
			}
			pickFood(0,0);
			System.out.println("#"+t+" "+MIN);
		}
	}
	
	
	static void pickFood(int count,int idx) {
		if(count == (N/2)) { //종료조건
			int diff = calcFoodDiff();
			if(MIN>diff) {
				MIN = diff;
			}
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(!selected[i]) {
				selected[i] = true;
				pickFood(count+1,idx+1);
				selected[i] = false;
			}
		}
	}

	static int calcFoodDiff() {
		foodA = 0;
		foodB = 0;
		for(int i=0;i<N;i++) {
			if(selected[i]) {
				for(int j=0;j<N;j++) {
					if(selected[j]) {
						foodA+=arr[i][j];
					}
				}
			}
				
			else {
				for(int j=0;j<N;j++) {
					if(!selected[j]) {
						foodB+=arr[i][j];
					}
				}
			}
		}
		
		return Math.abs(foodA-foodB);
	}

}

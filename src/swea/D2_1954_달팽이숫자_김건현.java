package swea;

import java.io.IOException;
import java.util.Scanner;

public class D2_1954_달팽이숫자_김건현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    for(int tc = 1; tc <= T; tc++) {
	        int N = sc.nextInt();
	        if(N == 1){
	            System.out.println("#" + tc);
	            System.out.println(1);
	            continue;
	        }
	        int x = 0;
	        int y = 0;
	        int dir = 0;
	        int[][] arr = new int[N][N];
	        //
	        for(int i = 0; i < N * N; i++) {
	            arr[x][y] = i + 1;
	            x += dx[dir];
	            y += dy[dir];
	            if(x < 0 || x >= N || y < 0 || y >= N) {
	                x -= dx[dir];
	                y -= dy[dir];
	                dir = (dir+1) % 4;
	                x += dx[dir];
	                y += dy[dir];
	            }

	            if(arr[x][y] != 0) {
	                x -= dx[dir];
	                y -= dy[dir];
	                dir = (dir + 1) % 4;
	                x += dx[dir];
	                y += dy[dir];
	            }
	        }
	        System.out.println("#" + tc);
	        for(int i = 0; i < N; i++){
	            for(int j = 0; j < N; j++) {
	                System.out.print(arr[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}

		    

}

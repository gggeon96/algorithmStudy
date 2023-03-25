package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5644_무선충전_김건현 {
	static int TOTAL;
	static int MAX;
	static int M;
	static int A;
	static BC[] bcs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;T>=t;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			TOTAL = 0;
			int[][] map = new int[11][11];
			int[] aMove = new int[M];
			int[] bMove = new int[M];
			bcs = new BC[A];
			Player playerA = new Player(1, 1);
			Player playerB = new Player(10, 10);
			
			//A의이동정보
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				aMove[j] = Integer.parseInt(st.nextToken());
			}
			//B의이동정보
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				bMove[j] = Integer.parseInt(st.nextToken());
			}
			
			//BC들 정보
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				int coverage = Integer.parseInt(st.nextToken());
				int performance = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(row, col, coverage, performance);
			}
			
//			System.out.println("========================");
//			for(int i=0;i<A;i++) {
//				System.out.println("BC"+i+" "+bcs[i].row+". "+bcs[i].col+". "+bcs[i].covarage+" ."+bcs[i].performance);
//			}
//			for(int i=0;i<M;i++) {
//				System.out.println(aMove[i]+" // "+bMove[i]);
//			}
//			System.out.println("========================");
			
			//M초간
			for(int i=0;i<M;i++) {
				int tmp = calc(playerA,playerB);
//				System.out.println(i+"초가 끝나고 나서 해당초의 최댓값 / TOTAL=> "+tmp+" / "+TOTAL);
				TOTAL+=tmp;
				move(aMove[i],playerA);
				move(bMove[i],playerB);
			}
			TOTAL+=calc(playerA,playerB);
			System.out.println("#"+t+" "+TOTAL);
			
		}
	}
	static int calc(Player playerA,Player playerB) {
		int max = 0; //해당 초에 얻을 수 있는 최대 배터리양
		int tmpA;
		int tmpB;
		for(int i=0;i<A;i++) {
			tmpA = 0;
			if(accessable(playerA, bcs[i])) {
				tmpA+=bcs[i].performance;
			}
			for(int j=0;j<A;j++) {
				tmpB= 0;
				if( accessable(playerB, bcs[j]) ) {
					tmpB+=bcs[j].performance;
				}
				int sum = tmpA+tmpB;
				//둘다 접속한다면 절반으로
				if(accessable(playerB, bcs[j])&&accessable(playerA, bcs[i])&&i==j) sum/=2;
				if(sum>max) {
					max = sum;
//					System.out.println("tmpAand B=> "+tmpA+" and "+tmpB);
//					System.out.println("i and J"+i+" and "+j);
				}
			}
		}
		
		return max;
	}
	
	//범위안에 해당 플레이어가 들어갈 수 있는지 체크
	static boolean accessable(Player player, BC bc) {
		int D = Math.abs(bc.row-player.row) + Math.abs(bc.col-player.col); 
		if(D<=bc.covarage) return true;
		return false;
	}
	
	static class Player{
		int row;
		int col;
		public Player(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static class BC {
		int row;
		int col;
		int covarage;
		int performance;
		
		public BC(int row, int col, int covarage, int performance) {
			super();
			this.row = row;
			this.col = col;
			this.covarage = covarage;
			this.performance = performance;
		}
	}
	
	static void move(int x,Player player) {
		int[] dx= {0,-1,0,1,0}; //상우하좌
		int[] dy = {0,0,1,0,-1};
		switch(x) {
		case 0:
			break;
		case 1:
			player.row+=dx[1];
			player.col+=dy[1];
			break;
		case 2:
			player.row+=dx[2];
			player.col+=dy[2];
			break;
		case 3:
			player.row+=dx[3];
			player.col+=dy[3];
			break;
		case 4:
			player.row+=dx[4];
			player.col+=dy[4];
			break;
		}
	}
	
}

package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;T>=t;t++) {
			st = new StringTokenizer( br.readLine());
			int H = Integer.parseInt(st.nextToken()); //높이
			int W = Integer.parseInt(st.nextToken()); //너비
			int row = Integer.MAX_VALUE; //전차의 행
			int col = Integer.MAX_VALUE; //전차의 열
			char[][] area = new char[H][W]; //필드생성
			for(int i=0;i<H;i++) {
				String str = br.readLine(); // 필드 한줄 읽기
				for(int j =0;j<W;j++) {
					area[i][j] = str.charAt(j);
				}
			}
			int N = Integer.parseInt(br.readLine());//사용자의 입력갯수
			String input = br.readLine(); //명령어들
			
			//전차의위치찾기
			for(int i=0;i<H;i++) {
				for(int j =0;j<W;j++) {
					if(area[i][j] == '>'||area[i][j] == '<'||area[i][j] == '^'||area[i][j] == 'v') {
						row = i;
						col = j;
						break;
					}
				}
			}
			int y=1;
			
			//명령어 수행
			for(char c:input.toCharArray()) {
				if(c=='U') {
					if((row-1)>=0 ) { //영역안이고 다음이동할 곳이 평지이면
						if(area[row-1][col] =='.') {
							area[row][col]='.'; //원래 있던자리를 평지로 바꾸고
							row--; //전차의 위치를 바꾸고							
						}
					} 
						area[row][col] = '^'; //전차의 방향을 바꾼다
				}else if(c=='D') {
					if((row+1)<H) {
						if(area[row+1][col]=='.') {
							area[row][col]='.';
							row++;							
						}
					}
					area[row][col] = 'v';
				}else if(c=='L') {
					if((col-1)>=0) {
						if(area[row][col-1]=='.') {							
							area[row][col]='.';
							col--;
						}
					}
					area[row][col] = '<';
				}else if(c=='R') {
					if((col+1)<W) {
						if(area[row][col+1]=='.') {
							area[row][col]='.';
							col++;							
						}
					}
					area[row][col] = '>';
				}
				else { //shoot
					if(area[row][col]=='^') {
						for(int i=row-1;i>=0;i--) { //현재 탱크위치부터 위쪽으로 벽돌벽있는지확인
							if(area[i][col]=='#')break;
							if(area[i][col]=='*') {
								area[i][col] = '.';
								break;
							}
						}
					}else if(area[row][col]=='v') {
						for(int i=row+1;i<H;i++) { 
							if(area[i][col]=='#')break;
							if(area[i][col]=='*') {
								area[i][col] = '.';
								break;
							}
						}
					}else if(area[row][col]=='<') {
						for(int i=col-1;i>=0;i--) { 
							if(area[row][i]=='#')break;
							if(area[row][i]=='*') {
								area[row][i] = '.';
								break;
							}
						}
					}else { //오른쪽 보고있을때
						for(int i=col+1;i<W;i++) { 
							if(area[row][i]=='#')break;
							if(area[row][i]=='*') {
								area[row][i] = '.';
								break;
							}
						}
					}
				}
//				System.out.println("---------"+(y++));
//				System.out.println("row: "+row+" col: "+col+ "command: "+c);
//				for(int i=0;i<H;i++) {
//					for(int j =0;j<W;j++) {
//						System.out.print(area[i][j]+" ");
//					}
//					System.out.println();
//				}
			}
			bw.write("#"+t+" ");
			bw.flush();
			for(int i=0;i<H;i++) {
				for(int j =0;j<W;j++) {
					bw.write(area[i][j]);
				}
				bw.write("\n");
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

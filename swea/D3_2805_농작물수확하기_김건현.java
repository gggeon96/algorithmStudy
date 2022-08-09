package day_0802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_2805_농작물수확하기_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;T>=t;t++) {
			int N = Integer.parseInt(br.readLine()); // n은홀수
			int[][] area = new int[N][N]; //필드생성
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					int tmp = str.charAt(j)-'0';
					area[i][j] = tmp;
				}
			}
			int middle = N/2; //가운데인덱스
			int sum = 0;
			int range = 0;
			for(int i=0;i<N;i++) {
				for(int j=middle-range;middle+range>=j;j++) { //각행의 파란색칸 범위설정
					sum+=area[i][j];
				}
				//파란색 칸이 한칸씩 증가
				if(i<middle) {
					range++;
				}
				else { //파란색 칸이 한칸씩 감소
					range--;
				}
			}
			bw.write("#"+t+" " +sum+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
}

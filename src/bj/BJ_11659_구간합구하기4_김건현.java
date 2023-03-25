package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum =0;
		int[] arr = new int[N];
		int[] total = new int[N+1];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine()); //배열 읽기
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
			total[i+1] = sum;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			ans = total[b]-total[a]+arr[b];
			bw.write(ans+"\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
		
	}

}

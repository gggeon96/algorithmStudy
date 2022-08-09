package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_수열_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] days = new int[N]; //
		int[] dp = new int[N]; //최대합
		
		st = new StringTokenizer(br.readLine());
		
		//dp[i] = days[i]~days[i-K+1]
		//초기화
		for(int i=0;i<N;i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}
		//dp배열초기화
		int max = Integer.MIN_VALUE;
		for(int i=0;i<K-1;i++) {
			dp[i] =-100000000;
		}
		for(int i=0;(K-1)>=i;i++) {
			dp[K-1]+= days[i];
		}
		
		
		for(int i=K;i<N;i++) {
			dp[i] = dp[i-1]-days[i-K]+days[i];
			if(max<dp[i]) max = dp[i];
		}
		System.out.println(max);
	}

}

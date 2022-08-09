package day_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891_DNA비밀번호_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		int sum = 0; //전체 유효한 key의개수
		int[] count = new int[4];//읽은 만큼의 문자열의ACGT개수 
		int[] ACGT = new int[4]; //key가 되기 위한ACGT개수 조건
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			ACGT[i] = tmp;
		}
		//count초기화
		for(int i=0;i<N;i++) {
			count[changeToNum(str.charAt(i))]++;
		}
		
		for(int i=N;i<S;i++) {
			if(isItValid(count,ACGT)) {
				sum++; //조건만족하면 키니까 키의개수총합인sum++
			}
			//제일뒤의 문자하나를 지우고 그 앞의 문자하나를 더해준다.
			count[changeToNum(str.charAt(i))]++;
			count[changeToNum(str.charAt(i-N))]--;
		}
		if(isItValid(count,ACGT)) {
			sum++; 
		}
		System.out.println(sum);
	}
	
	//해당 문자열이 key가 될 수 있는지 체크하는 메서드
	static boolean isItValid(int[]count, int[]ACGT) {
		if(count[0]>=ACGT[0]&&count[1]>=ACGT[1]&&count[2]>=ACGT[2]&&count[3]>=ACGT[3]) {
			return true;
		}
		return false;
	}
	
	//ACGT를 각각의 배열인덱스에 매핑해주는 메서드
	static int changeToNum(char c) {
		switch(c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		}
		return -1;
	}

}


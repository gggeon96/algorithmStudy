package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2605_줄세우기_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		ArrayList<Integer> list = new ArrayList<>();
		int tmp;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
//			for(int x:arr) System.out.print(x+" ");
//			System.out.println();
			int num = Integer.parseInt(st.nextToken()); 
			list.add(i-num,(i+1));
			
			
		}
		for(int x:list) System.out.print(x+" ");
	}

}

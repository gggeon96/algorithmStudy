package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호_김건현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "-+",true);
		ArrayList<String> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		
		int n = calc(list);
		//for(String s:list) System.out.println(s);
		System.out.println(n);
		
		
		
	
	}
	
	static int calc(ArrayList<String> list) {
		int sum=0;
		boolean isMinus = false;
		int i=0;
		int end = list.size();
		while(true) {
			//부호이면
			if(i==end) break;
			String s = list.get(i);
			if(s.equals("-")) {
				if(isMinus) {
					i++;
					continue;
				}
				isMinus = true;
				
			}
			//+기호이면
			else if(s.equals("+")) {
				i++;
			}
			//숫자이면
			else {
				int tmp = Integer.parseInt(s);
				if(isMinus) {
					sum-=tmp;
				}else {
					sum+=tmp;
				}
				i++;
			}
		}
		
		return sum;
	}

}

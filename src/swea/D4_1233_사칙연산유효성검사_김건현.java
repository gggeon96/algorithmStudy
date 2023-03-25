package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사_김건현 {
	

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int T = 1; 10>=T;T++) {
			int N= Integer.parseInt(br.readLine()); //171
			int ans = 1;
			int tmp;
			int i;
			String c;
			for(i=1;i<=N;i++) {
				st= new StringTokenizer(br.readLine()); //1 - 2 3
				tmp = Integer.parseInt(st.nextToken()); // N=171 -> 1~171
				c = st.nextToken(); //-
				if(c ==null) {
					ans = 0;
					break;
				}
				else if(c.equals("-")||c.equals("+")||c.equals("/")||c.equals("*")) {
					if(st.countTokens()!=2) {
						ans = 0;
						break;
					}
				}else { //1 18
					if(st.hasMoreTokens()) {
						ans = 0;
						break;
					}
				}
			}
			i++;
			for(;i<=N;i++) {
				br.readLine();
			}
			
			System.out.println("#"+T+" "+ans);
			
		}
	}

}

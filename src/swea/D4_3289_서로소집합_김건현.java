package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_3289_서로소집합_김건현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		//testCase 수만큼 반복
		for(int t=1;T>=t;t++) {
			bw.write("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] parent = new int[n+1];
			for(int i=1;i<n+1;i++) {
				parent[i] = i;
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch(command) {
				case 0:
					union(a, b ,parent);
					break;
				case 1:
					a = find(a,parent);
					b = find(b,parent);
					bw.write(((a==b)?1:0)+"");
					break;
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int find(int x, int[] parent) {
		if(parent[x] != x) {
			parent[x] = find(parent[x],parent);
		}
		return parent[x];
	}
	
	static void union(int a,int b, int[] parent) {
		a = find(a,parent);
		b = find(b,parent);
		if(a>b)parent[a] = b;
		else parent[b] = a;
	}
}

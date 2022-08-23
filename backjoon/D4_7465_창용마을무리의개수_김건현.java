package day_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수_김건현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;T>=t;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;
			boolean[] counts = new boolean[N+1];
			int[] parent  = new int[N+1];
			//parent를 자기자신으로 초기화
			for(int i=0;i<N+1;i++) {
				parent[i] = i;
			}
			//관계의 수 M개만큼 받기
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(from,to,parent);
			}
			System.out.println("Parent배열");
			for(int i=1;i<N+1;i++) {
				System.out.print(parent[i]+" ");
			}
			System.out.println("---------");
			for(int i=1;i<N+1;i++) {
				counts[parent[i]] = true;
			}
			for(int i=1;i<N+1;i++) {
				if(counts[i]) count++;
			}
			for(int i=1;i<N+1;i++) {
				System.out.print(counts[i]+" ");
			}
			System.out.println("#"+t+" "+count);
		}
	}
	
	static int find(int x,int[] parent) {
		if(parent[x] != x) {
			parent[x] = find(parent[x],parent);
		}
		return parent[x];
	}
	
	static void union(int a,int b, int[] parent) {
		a = find(a,parent);
		b = find(b,parent);
		if(a>b) parent[a] = b;
        else parent[b] = a;
	}

}

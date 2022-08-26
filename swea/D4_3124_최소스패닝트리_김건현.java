package day_0824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리_김건현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		//testCase 수만큼 반복
		for(int t=1;T>=t;t++) {
			
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			int V = Integer.parseInt(st.nextToken()); //정점의 개수
			int E = Integer.parseInt(st.nextToken()); //간선의 개수
			List<Edge> edges = new ArrayList<>();
			int[] parent = new int[V+1]; //정점번호 1번부터니깬
			//정점들의 아부지를 자기자신으로
			for(int i=1;i<V+1;i++) {
				parent[i] = i;
			}
			//간선들을 받아온다.
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long w = Long.parseLong(st.nextToken());
				edges.add(new Edge(a, b, w));
			}
			Collections.sort(edges);
			for(Edge e:edges) {
				//둘이 부모가 다르다면 -> 사이클이 형성되지 않는다면
				if(find(e.a, parent) != find(e.b,parent)) {
					union(e.a,e.b,parent);
					sum+=e.w; //가중치 더해주기
				}
			}
			
			//출력
			bw.write("#"+t+" "+sum+"\n");
			
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		long w;//가중치
		public Edge(int a, int b, long w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w<o.w?-1:1;
		}
		
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

package day_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class D4_1251_하나로_김건현 {
	static Node[] nodes;
	static int[] parent;
	static int N;
	static double taxRate;
	static double sum;
	static List<Vertex> vertexList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		int T = Integer.parseInt(br.readLine());
		//해당testCase만큼 반복
		for(int t=1;T>=t;t++) {
			
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N];
			sum = 0;
			parent = new int[N];
			vertexList = new ArrayList<>();
			st1 = new StringTokenizer(br.readLine());
			
			
			//Vertex에 값을 한번에 넣기 위해 우선 저장
			int[] st1Arr = new int[N];
			int[] st2Arr = new int[N];
			for(int i=0;i<N;i++) {
				st1Arr[i] = Integer.parseInt(st1.nextToken());
			}
			st1 = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				st2Arr[i] = Integer.parseInt(st1.nextToken());
			}
			taxRate = Double.parseDouble(br.readLine());
			
			//Node배열에 초기화 parent자기자신으로 초기화
			for(int i=0;i<N;i++) {
				nodes[i] = new Node(st1Arr[i], st2Arr[i]);
				parent[i] = i;
			}
			
			//vertexList초기화
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					long range = getRange(nodes[i],nodes[j]);
					vertexList.add(new Vertex(range,i,j));
				}
			}
			
			//간선의 길이별로 정렬
			Collections.sort(vertexList);
			
			//크루스깔 알고뤼쥼
			for(Vertex v:vertexList) {
				if(find_parent(v.from)!=find_parent(v.to)) {
					union(v.from,v.to);
					sum+= v.range*(taxRate);
				}
			}
			
			
			//출력
			System.out.println("#"+t+" "+Math.round(sum));
		}
		br.close();
	}
	
	static class Vertex implements Comparable<Vertex>{
		long range;
		int to;
		int from;
		public Vertex(long range, int to, int from) {
			super();
			this.range = range;
			this.to = to;
			this.from = from;
		}
		@Override
		public int compareTo(Vertex o) {
			return (this.range-o.range)<0?-1:1;
		}
	}
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	

	static int find_parent(int x) {
		//parent가 자기자신이 아니면
		if(x!=parent[x]) {
			return parent[x] = find_parent(parent[x]);
		}
		return parent[x];
	}
	
	static void union(int a, int b) {
		//부모의 노드를 가져옴
		a = find_parent(a);
		b = find_parent(b);
		if(a<b) {
			parent[b]= a; 
		}else {
			parent[a]= b; 
		}
	}
	
	static long getRange(Node node1, Node node2) {
		return (long) ((long) Math.pow(node1.x-node2.x,2)+Math.pow(node1.y-node2.y, 2));
	}
	
	

}

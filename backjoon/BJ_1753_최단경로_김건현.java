package day_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_1753_최단경로_김건현 {
	public static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(); 
        for(int i=0;i<V;i++) {
        	graph.add(new ArrayList<Node>());
        }
        //간선 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            //같은 간선이라도 더 작으면 갱신
            
            //u에서 v로 가는데 비용은 w
            graph.get(u).add(new Node(v,w));
        }
        
        boolean[] visited = new boolean[V];
        int[] d = new int[V];
        Arrays.fill(d, INF);
        d[start] = 0;
        
        //로직
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //출발점을 넣는다.
        pq.offer(new Node(start,d[start]));
        while(!pq.isEmpty()) {
        	//하나 꺼내오기
        	Node node = pq.poll();
        	int dist = node.weight; //현재 노드까지의 비용
        	int now = node.index; //현재 노드
        	if(d[now]<dist) continue;
        	for(int i=0;i<graph.get(now).size();i++) {
        		int cost = d[now]+ graph.get(now).get(i).weight;
        		//갱신조건
        		if(cost<d[graph.get(now).get(i).index]) {
        			d[graph.get(now).get(i).index] = cost;
        			pq.offer(new Node(graph.get(now).get(i).index,cost));
        		}
        	}
        }
        
        for (int i = 0; i < V; i++) {
            if (d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }
        
        
        
	}
	
	static class Node implements Comparable<Node>{
    	int index;
    	int weight;
		public Node(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
    	
    }

}

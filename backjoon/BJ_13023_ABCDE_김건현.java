package day_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE_김건현 {
	static int N;
	static boolean[] visited;
	static boolean flag = false;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N]; //방문체크
		list = new ArrayList[N]; //배열의크기가 2000*2000이 되면 시간초과가 나니 list로 관리
		for(int i=0;i<N;i++) { //리스트 초기화
			list[i] = new ArrayList<>();
		}
		
		//간선 초기화. list에 add해준다
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		//각각을 출발점으로 해서 dfs실행
		for(int i=0;i<N;i++) {
			dfs(0,i);
		}
		
		//flag의 상태에 따라 1혹은 0 출력
		System.out.println(flag?1:0);
		
	}
	
	static void dfs(int count,int idx) {
		if(flag) return;//true이면 더이상 탐색할 필요없음
		if(count == 4) { //4개가 된다면 true로 플래그바꾸기
			flag = true;
			return;
		}
		visited[idx] = true; //들어갈 때 방문체크
		for(int next:list[idx]) { // 해당 행의 각 열에 대해
			if(!visited[next]) { //방문을 하지 않았다면
				dfs(count+1,next); //방문을 해주고 count+1
			}
		}
		visited[idx] = false; //방문체크 해제
	}

}

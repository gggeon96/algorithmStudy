package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2_김건현 {
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        //초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //각 점을 출발점으로 하는 dfs실행
        for (int i = 0; i < N; i++) {
            dfs(0, i, 0, i);
        }

        //출력
        System.out.println(ans);
    }

    /**
     *
     * @param count = 현재 방문한 도시 수
     * @param now = 지금 방문한 도시 넘버
     * @param sum = 최소값을 구하기 위한 가중치 합
     * @param start = 시작 점.마지막에 돌아올 때 시작점과 길이 있는지 체크후 있으면 더한다.
     */
    static void dfs(int count, int now,int sum,int start){
        if(count == N-1&& sum>0){
//            System.out.println(recent+"->"+start);
//            System.out.println("===========");
            if(map[now][start]!=0){ //돌아갈 수 있는 길이 있을경우. << 잊지말기....
                sum += map[now][start]; //돌아가는길 더해주기
                if(sum<ans) ans = sum; //대소비교 후 갱신
            }
            return;
        }

        //들어올 때 체크.
        visited[now] = true;
        for (int i = 0; i < N; i++) {
            //방문하지 않았고 길이 있을 경우
            if(!visited[i]&&map[now][i]!=0){
                //비용을 구해서 dfs로 넘겨주기
                int w = map[now][i];
//                System.out.println(recent+"->"+i);
                dfs(count+1,i,sum+w,start);
            }
        }
        //방문체크 해제
        visited[now] = false;

    }

}

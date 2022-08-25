package com.kim.backjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로_김건현 {
    static int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;
        int[][] arr = new int[V][V];
        boolean[] visited = new boolean[V];
        int[] d = new int[V];

        //d초기화
        for (int i = 0; i < V; i++) {
            d[i] = INF;
        }
        d[start] = 0;

        //arr초기화
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) arr[i][j] = 0;
                arr[i][j] = INF;
            }
        }

        //간선 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            //같은 간선이라도 더 작으면 갱신
            if (arr[u][v] > w) {
                arr[u][v] = w;
            }
        }

//        PriorityQueue<Integer> pq = new
        //로직
        int min, minVertex;
        for (int i = 0; i < V; i++) {
            //step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
            // (방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기)
            min = INF;
            minVertex = 0;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && (min > d[j])) {
                    min = d[j];
                    minVertex = j;
                }
            }



            //step2. 방문쳌
//            for (int k = 0; k < V; k++) {
//                if (d[k] == INF) System.out.print("INF ");
//                else System.out.print(d[k]+" ");
//            }
//            System.out.println();
            visited[minVertex] = true;

            //step 3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 유리하면 갱신
            for (int j = 0; j < V; j++) {
                if (!visited[j] && d[j] > (d[minVertex] + arr[minVertex][j])) {
                    d[j] = d[minVertex] + arr[minVertex][j]; //갱신
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }


    }
}

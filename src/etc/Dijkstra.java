package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//인접행렬버전
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        int[][] adjMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0;//출발지
        int end = start - 1; //도착정점
        //다익스트라 알고리즘에 필요한 자료구조
        int[] D = new int[V];//출발지에서 자신으로 오는데 소요되는 최소비용
        boolean[] visited = new boolean[V];

        //출발정점 처리
        Arrays.fill(D, Integer.MAX_VALUE);
        D[start] = 0;

        int min, minVertex = -1;
        for (int i = 0; i < V; i++) {
            //step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
            // (방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기)
            min = Integer.MAX_VALUE;
            minVertex = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[i] && min > D[j]) {
                    min = D[j];
                    minVertex = j;
                }
            }

            //step2. 방문철
            visited[minVertex] = true;
            if(minVertex == end) break; //만약 우리가 원하는 정점 나왔으면 end

            //step 3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 유리하면 갱신
            for (int j = 0; j < V; j++) {
                if (!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
                    D[j] = D[minVertex] + adjMatrix[minVertex][j]; //갱신

                }
            }
        }
        //출력
        System.out.println(D[end]);

    }
}

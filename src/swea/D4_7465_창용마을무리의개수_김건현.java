package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수_김건현 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; T >= t; t++) {
            //초기화
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;
            boolean[] counts = new boolean[N + 1]; //번호는 1번부터 있으니 0인덱스는 사용하지 않고 N+1로 할당
            int[] parent = new int[N + 1];

            //parent를 자기자신으로 초기화
            for (int i = 0; i < N + 1; i++) {
                parent[i] = i;
            }
            //관계의 수 M개만큼 받기
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()); //출발지
                int to = Integer.parseInt(st.nextToken()); //도착지 하지만 양방향이다.
                union(from, to, parent); //해당 간선에 대해 union연산
            }

            //find연산을 한번씩 수행해 주어서 parent테이블을 갱신
            for (int i = 1; i < N + 1; i++) {
                counts[find(i, parent)] = true;
            }
            //무리의 수 세기
            for (int i = 1; i < N + 1; i++) {
                if (counts[i]) count++;
            }
            //출력
            System.out.println("#" + t + " " + count);
        }
    }

    //부모를 찾는 함수. 경로 압축이 적용된다.
    static int find(int x, int[] parent) {
        //부모가 자기자신이 아니라면 -> 더 거슬러 올라가야한다
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); //부모를 찾고 그것을 자기자신의 부모로 한다
        }
        return parent[x]; //리턴
    }

    //루트가 더 작은 노드로 합치는 연산
    static void union(int a, int b, int[] parent) {
        a = find(a, parent); //a의 부모를 찾는다
        b = find(b, parent); //b의 부모를 찾는다
        if (a > b) parent[a] = b; //b의 부모가 더 크면 a의 부모는 b가된다.
        else parent[b] = a; //a의 부모가 더 크면 b의 부모는 a가 된다.
    }

}

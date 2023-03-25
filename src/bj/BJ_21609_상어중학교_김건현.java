package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21609_상어중학교_김건현 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxRow=-1;
        int maxCol=-1;
        int maxCnt=1;
        //1번인 그룹부터 찾기
        for (int blockNum = 1; blockNum <= M; blockNum++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j]==blockNum){
                        visited[i][j] = true;
                        int cnt = bfs(i, j);
                        if(cnt>maxCnt){
                            maxRow=i;
                            maxCol=j;
                            maxCnt=cnt;
                        }
                    }
                }
            }
            visitedReset();
        }

        System.out.println(maxRow+" "+maxCol+" "+maxCnt);

//        while (true) {
//            if(maxRow==-1 && maxCol == -1) break;
//
//
//        }




    }
    static void visitedReset(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==0){
                    visited[i][j] = false;
                }
            }
        }
    }

    static int bfs(int row, int col){
        int cnt = 1;
        int blockNum = map[row][col];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int pos = 0; pos < 4; pos++) {
                int nx = row+dx[pos];
                int ny = col+dy[pos];
                if (isRange(nx, ny)) {
                    if(map[nx][ny]==blockNum&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        cnt++;
                        q.offer(new Point(nx, ny));
                    }else if(map[nx][ny]==0&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        cnt++;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return cnt;
    }

    static boolean isRange(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N) return true;
        return false;
    }
    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

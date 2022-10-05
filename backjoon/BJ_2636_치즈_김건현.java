package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈_김건현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sec = 0;
        int cheese = 0;
        while (check(map)) {
            sec++;
            mark(map);
            cheese = melt(map);
        }
        System.out.println(sec + "\n" + cheese);

    }

    /*아직 1이 남았다면 true반환*/
    static boolean check(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //모든 꼭지점에서 BFS
    static void mark(int[][] map) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int R = map.length;
        int C = map[0].length;
        q.offer(new Point(0,0));
        q.offer(new Point(R-1,0));
        q.offer(new Point(0,C-1));
        q.offer(new Point(R-1,C-1));
        visited[0][0] = true;
        visited[0][C-1] = true;
        visited[R-1][0] = true;
        visited[R-1][C-1] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int pos = 0; pos < 4; pos++) {
                int nx = p.row+dx[pos];
                int ny = p.col+dy[pos];
                if (isRange(nx, ny, R, C)&&!visited[nx][ny]) {
                    if(map[nx][ny]==1){
                        visited[nx][ny] = true;
                        map[nx][ny]=2;
                    }else if(map[nx][ny]==0){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    //치즈를 녹이고 녹인 개수 반환
    static int melt(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //범위체크
    static boolean isRange(int nx, int ny,int R,int C) {
        if(nx>=0&&nx<R&&ny>=0&&ny<C) return true;
        return false;
    }

    //큐에담을 클래스
    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}

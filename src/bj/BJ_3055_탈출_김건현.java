package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출_김건현 {
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int MINUTE = 0;
    static Queue<Point> waterQ;
    static Queue<Point> manQ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        waterQ = new LinkedList<>();
        manQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    manQ.offer(new Point(i, j));
                    map[i][j] = '.';
                } else if (map[i][j] == '*') {
                    waterQ.offer(new Point(i, j));
                }
            }
        }

        MINUTE = play();
        if(MINUTE==0){
            System.out.println("KAKTUS");
        }else{
            System.out.println(MINUTE);
        }

    }

    //
    static int play() {
        int minute=0;
        while (!manQ.isEmpty()) {
//            System.out.println("MINUTE:"+minute);
//            print();

            int size = waterQ.size();
            //우선 물이 퍼진다
            for (int rep = 0; rep < size; rep++) {
                Point p = waterQ.poll();
                for (int pos = 0; pos < 4; pos++) {
                    int nx = p.row+dx[pos];
                    int ny = p.col+dy[pos];
                    if(isRange(nx,ny)&&map[nx][ny]=='.'){
                        map[nx][ny] = '*';
                        waterQ.offer(new Point(nx, ny));
                    }
                }
            }

            size = manQ.size();
            for (int rep = 0; rep < size; rep++) {
                Point p = manQ.poll();
//                System.out.println("row:"+p.row+" col:"+p.col);
                if(map[p.row][p.col]=='D') return minute;
                for (int pos = 0; pos < 4; pos++) {
                    int nx = p.row+dx[pos];
                    int ny = p.col+dy[pos];
                    if (isRange(nx, ny)&&!visited[nx][ny]) {
                        if(map[nx][ny]=='.'||map[nx][ny]=='D'){
                            visited[nx][ny]=true;
                            manQ.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            minute++;
        }
        return 0;
    }

    static boolean isRange(int row, int col) {
        if(row>=0&&row<R&&col>=0&&col<C) return true;
        return false;
    }

    static void print(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===========");
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

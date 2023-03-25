package study;

import java.util.Scanner;

public class 게임개발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];
        //북0 동1 남2 서3 인덱스순서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int row = sc.nextInt();
        int col = sc.nextInt();
        int dir = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visited[row][col] = 1;
        count++;
        int turn_time = 0;
        while (true) {
            dir-=1;
            if(dir<0) dir =3;
            if (checkValid(row+dx[dir],col+dy[dir],N,M)
                    &&visited[row+dx[dir]][col+dy[dir]] == 0
                    && map[row+dx[dir]][col+dy[dir]] == 0) {
                row+=dx[dir];
                col+=dy[dir];
                visited[row][col] = 1;
                count++;
                turn_time = 0;
                continue;
            }else{
                turn_time++;
            }
            if(turn_time==4){
                row -= dx[dir];
                col -= dy[dir];
                if(!checkValid(row,col,N,M)||map[row+dx[dir]][col+dy[dir]] == 1){
                    break;
                }
            }
            //여기 왔다는건. 방문할 수 있는 곳이 없다는것


        }

        System.out.println(count);
    }

    static boolean checkValid(int x, int y,int N, int M) {
        if(x>=0&&y>=0&&x<N&&y<M) return true;
        return false;
    }

}

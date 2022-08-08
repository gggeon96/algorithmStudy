package com.kim.swea;

import java.util.Scanner;

public class D2_1954_달팽이숫자_김건현 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //배열의 크기 받기
            if(N == 1){ //한개면 즉시 출력후 다음 케이스로
                System.out.println("#" + t +" "+1);
                continue;
            }
            int x = 0;
            int y = 0;
            int dir = 0;
            int[][] area = new int[N][N];

            for(int i = 0; i < N * N; i++) {
                area[x][y] = i + 1;
                x += dx[dir];
                y += dy[dir];
                if(x < 0 || x >= N || y < 0 || y >= N) { //범위초과시(벽에 닿을시)
                    x -= dx[dir];
                    y -= dy[dir];
                    dir = (dir+1) % 4; //방향은 상하좌우. %로 인덱스 넘어가지않게 해준다.
                    x += dx[dir];
                    y += dy[dir];
                }
                if(area[x][y] != 0) { //이미 지나온곳이라면
                    x -= dx[dir];
                    y -= dy[dir];
                    dir = (dir + 1) % 4;
                    x += dx[dir];
                    y += dy[dir];
                }
            }
            System.out.println("#" + t);
            for(int i = 0; i < N; i++){ //출력
                for(int j = 0; j < N; j++) {
                    System.out.print(area[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

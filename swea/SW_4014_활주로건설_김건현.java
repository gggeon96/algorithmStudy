package com.kim.swea;

import java.io.*;
import java.util.StringTokenizer;

public class SW_4014_활주로건설_김건현 {
    static int N;
    static int X;
    static int[][] map;
    static boolean[][] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            //초기화
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            road = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로방향 활주로 검사
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 1; j < N; j++) {
                    if(map[i][j] != map[i][j-1]){
                        if(!checkLeftRight(i,j)){
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag){
                    cnt++;
//                    System.out.println(i+"행 활주로 성공");
                }

            }

            road = new boolean[N][N]; //같은 땅이라도 세로로 깔렸어도 가로로 깔수있다. -> 배열 초기화

            //세로 방향 활주로 건설
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 1; j < N; j++) {
                    if(map[j][i] != map[j-1][i]){
                        if(!checkUpDown(j,i)){
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag) {
                    cnt++;
//                    System.out.println(i+"열 활주로 성공");
                }
            }
            bw.write("#"+t+" "+cnt+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    /*내 왼쪽블럭과 높이 차이가 있다면
    왼쪽과 자기자신중 누가더 작은지 찾고,
     경사로 깔 수 있는지 체크
     경사로 깔고 난 후에는 road배열에 길있음으로 체크
     */
    static boolean checkLeftRight(int row, int col){
        int cnt = 0;
        if(Math.abs(map[row][col]-map[row][col-1]) != 1) return false;
        //왼쪽이 더 낮음
        if(map[row][col]>map[row][col-1]){
            for(int i=col-1;i>=0;i--){
                if(X==cnt) break;
                if(map[row][i]==map[row][col-1] && !road[row][i]){
                    cnt++;
                    continue;
                }else{
                    return false;
                }
            }
            if(cnt ==X) {
                int i=1;
                while(cnt>=i){
                    road[row][col-i] = true;
                    i++;
                }
                return true;
            }
        }
        //왼쪽이 더 높음
        if(map[row][col]<map[row][col-1]){
            for(int i=col;i<N;i++){
                if(X==cnt) break;
                if(map[row][i]==map[row][col] && !road[row][i]){
                    cnt++;
                    road[row][i] = true;
                    continue;
                }else{
                    return false;
                }
            }
            if(cnt ==X) {
                int i=0;
                while(cnt>i){
                    road[row][col+i] = true;
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    /*내 위쪽블럭과 높이 차이가 있다면
    위과 자기자신중 누가더 작은지 찾고,
     경사로 깔 수 있는지 체크
     경사로 깔고 난 후에는 road배열에 길있음으로 체크
     */
    static boolean checkUpDown(int row,int col){
        if(Math.abs(map[row][col]-map[row-1][col]) != 1) return false;
        int cnt = 0;
        //위쪽이 더 낮음
        if(map[row][col]>map[row-1][col]){
            for(int i=row-1;i>=0;i--){
                if(X==cnt) break;
                if(map[i][col]==map[row-1][col] && !road[i][col] ){
                    cnt++;
                    continue;
                }else{
                    return false;
                }
            }
            if(cnt ==X) {
                int i=1;
                while(cnt>=i){
                    road[row-i][col] = true;
                    i++;
                }
                return true;
            }
        }
        //위쪽이 더 높음
        if(map[row][col]<map[row-1][col]){
            for(int i=row;i<N;i++){
                if(X==cnt) break;
                if(map[i][col]==map[row][col] && !road[i][col]){
                    cnt++;
                    continue;
                }else{
                    return false;
                }
            }
            if(cnt ==X) {
                int i=0;
                while(cnt>i){
                    road[row+i][col] = true;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
}

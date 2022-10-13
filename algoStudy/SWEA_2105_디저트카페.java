package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
    static int N;
    static int[][] map;
    static int[][] dir = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    static int MAX;
    static ArrayList<Integer> list;
    static boolean[] dessert;
    static int startRow;
    static int startCol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; T >= t; t++) {
            //초기화
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dessert = new boolean[101];
            MAX = Integer.MIN_VALUE;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    startRow = i;
                    startCol=j;
                    dfs(i, j, 0, 0, 0, 0, 0, 0,0);
                }
            }
            if(MAX==Integer.MIN_VALUE){
                System.out.println("#"+t+" "+"-1");
            }else{
                System.out.println("#"+t+" "+MAX);
            }

        }
    }

    static void dfs(int row, int col, int turn, int goA, int goB,int goC,int goD, int sum,int cnt) {
//        System.out.println("getin "+row+", "+col);
        int add = map[row][col]; //더할 숫자
        if(dessert[add]) {
            if(startCol==col && startRow==row){
                MAX = Math.max(MAX,cnt);
                return;
            }
//            System.out.println("duplicate "+add);
            return;
        }
        dessert[add]  = true;

        /*왼쪽아래를 보고있다면, 꺾던가, 앞으로 그대로 가던가.*/
        if(turn ==0){
            //앞으로 그대로 가기
            int nRow = row+dir[0][0];
            int nCol = col+dir[0][1];

            if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N)
                dfs(nRow,nCol,turn,goA+1,goB,goC,goD,sum+add,cnt+1);
            //꺾기
            if(goA>0){
                int nRowTurn = row+dir[1][0];
                int nColTurn = col+dir[1][1];
                if (nRowTurn >= 0 && nRowTurn < N && nColTurn >= 0 && nColTurn < N)
                    dfs(nRowTurn,nColTurn,turn+1,goA,goB+1,goC,goD,sum+add,cnt+1);
            }

        }else if(turn ==1){
            //앞으로 그대로 가기
            int nRow = row+dir[1][0];
            int nCol = col+dir[1][1];
            if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N)
                dfs(nRow,nCol,turn,goA,goB+1,goC,goD,sum+add,cnt+1);
            //꺾기
            if(goB>0){
                int nRowTurn = row+dir[2][0];
                int nColTurn = col+dir[2][1];
                if (nRowTurn >= 0 && nRowTurn < N && nColTurn >= 0 && nColTurn < N)
                    dfs(nRowTurn,nColTurn,turn+1,goA,goB,goC+1,goD,sum+add,cnt+1);
            }
        }
        //
        else if(turn ==2){
            if(goA==goC){
                int nRow = row+dir[3][0];
                int nCol = col+dir[3][1];
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N)
                    dfs(nRow,nCol,turn+1,goA,goB,goC,goD+1,sum+add,cnt+1);
            }else{
                int nRow = row+dir[2][0];
                int nCol = col+dir[2][1];
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N)
                    dfs(nRow,nCol,turn,goA,goB,goC+1,goD,sum+add,cnt+1);
            }
        }
        else if(turn ==3){
                int nRow = row+dir[3][0];
                int nCol = col+dir[3][1];
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N)
                    dfs(nRow,nCol,turn,goA,goB,goC,goD+1,sum+add,cnt+1);
        }
        dessert[add] = false;

    }
}

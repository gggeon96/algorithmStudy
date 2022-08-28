//package com.kim.algoStudy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class 헌터 {
//    static int N;
//    static int[][] map;
//    static int MIN;
//    static int SIZE;
//    static Point[] Moster;
//    static Home[] Home;
//    static Point[] points;
//    static boolean[] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//
//        for (int t = 1; t <= T; t++) {
//            MIN = Integer.MAX_VALUE;
//            N = Integer.parseInt(br.readLine());
//
//
//            Moster = new Point[4];
//            Home = new Home[4];
//            int homeIdx = 0;
//            int MosterIdx = 0;
//
//
//            //초기화
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    int n = Integer.parseInt(st.nextToken());
//                    //집이라면
//                    if(n<0){
//                        Home[homeIdx++] = new Home(i, j, false);
//                    }else if(n>0){
//                        Moster[MosterIdx++] = new Point(i,j);
//                    }
//                }
//            }
//            SIZE = MosterIdx; //몬스터 개수
//            points = new Point[SIZE*2];
//            visited = new boolean[SIZE*2];
//            int pointIdx = 0;
//            for(int i=0;i<SIZE;i++){
//                points[i] = Moster[i];
//            }
//            for(int i=SIZE;i<SIZE*2;i++){
//                points[i] = Home[i];
//            }
//            SIZE *=2;
//            Point[] tmp = new Point[SIZE];
//
//
//
//
//
//
//
//
//            System.out.println("#"+t+" "+MIN);
//        }
//    }
//
//    static void dfs(int idx,Point arr){
//        //종료조건
//        if(idx==SIZE){
//
//            return;
//        }
//
//        for(int i=0;i<SIZE;i++){
//            //방문안했다면
//            if(!visited[i]){
//                if()
//            }
//        }
//
//
//    }
//
//
//
//    static class Point{
//        int row;
//        int col;
//
//        public Point(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }
//
//    static class Home extends Point{
//        boolean isClear;
//
//        public Home(int row, int col, boolean isClear) {
//            super(row, col);
//            this.isClear = isClear;
//        }
//    }
//
//    static int range(int r1,int c1,int r2,int c2){
//        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
//    }
//
//
//
//}

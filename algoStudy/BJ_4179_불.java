//package com.kim.algoStudy;
//
//import java.awt.Point;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BJ_4179_불 {
//    static int R;
//    static int C;
//    static int minTime = Integer.MAX_VALUE;
//    static char[][] area;
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    public static void main(String[] args) throws IOException {
//        //초기화
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        area = new char[R][C];
//        ArrayList<Point> fires = new ArrayList<>();
//        Point J;//지훈이
//        for (int i = 0; i < R; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < C; j++) {
//                area[i][j] = line.charAt(j);
//                if (area[i][j] == 'J') {
//                    J = new Point(i, j);
//                }else if(area[i][J] =='F'){
//                    fires.add(new Point(i, j));
//                }
//            }
//        }
//
//        //로직
//
//
//
//
//    }
//
//    static int play() {
//        int time = 0;
//        for (int i = 0; i < 4; i++) {
//
//        }
//    }
//
//    static boolean isRange(int x, int y) {
//        if (x >= 0 && x < R && y >= 0 && y < C)
//            return true;
//        return false;
//    }
//
////    static void fire(char[] )
//}

package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_김건현 {
    static int MAX = Integer.MIN_VALUE;
    static int R;
    static int C;
    static int[][] area;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        area = new int[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                area[i][j] = str.charAt(j)-'A';
            }
        }
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(area[i][j]+" ");
//            }
//            System.out.println();
//        }
        visit(0, 0, 0);
        System.out.println(MAX);


    }

    static boolean isPossible(int row, int col) {
        if (row >= 0 && row < R && col >= 0 && col < C) {
            return true;
        }
        return false;
    }

    static void visit(int count, int row, int col) {
        if (visited[area[row][col]]) {
            MAX = Math.max(MAX, count);
            return;
        } else {
            visited[area[row][col]] = true;
            for (int i = 0; i < 4; i++) {
                int x = row + dx[i];
                int y = col + dy[i];
                if (!isPossible(x, y)) continue;
                visit(count + 1, x, y);
            }
            visited[area[row][col]] = false;
        }
    }

}

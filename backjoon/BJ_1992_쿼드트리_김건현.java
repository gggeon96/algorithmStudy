package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리_김건현 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        draw(N, 0, 0);
        System.out.println(sb.toString());
    }

    static void draw(int n, int row, int col) {
        if(isPossible(n,row,col)){
            sb.append(arr[row][col]);
            return;
        }
        else{
            sb.append('(');
            draw(n/2,row,col);
            draw(n / 2, row, col + (n / 2));
            draw(n / 2, row + (n / 2), col);
            draw(n / 2, row + (n / 2), col + (n / 2));
            sb.append(')');
        }


        // n==2일때
//        sb.append('(');
//        if (n == 2) {
//            sb.append(arr[row][col]);
//            sb.append(arr[row][col + 1]);
//            sb.append(arr[row + 1][col]);
//            sb.append(arr[row + 1][col + 1]);
//            sb.append(')');
//            return;
//        } else if (n == 1) {
//            sb.append(arr[row][col]);
//            sb.append(')');
//            return;
//        }
//        int tmp;
//        boolean flag;

//        //전체
//        flag = true;
//        tmp = arr[row][col];
//        for (int i = row; i < n; i++) {
//            for (int j = col; j < n; j++) {
//                if (arr[i][j] != tmp) ;
//                flag = false;
//            }
//        }
//        if (flag) {
//            System.out.println("------------------");
//            sb.append(tmp);
//            sb.append(')');
//            return;
//        }


        //좌상
//        flag = true;
//        tmp = arr[row][col];
//        for (int i = row + 0; i < n / 2; i++) {
//            for (int j = col + 0; j < n / 2; j++) {
//                if (arr[i][j] != tmp) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (!flag) break;
//        }
//        if (!flag) {
//            draw(n / 2, row, col);
//        } else
//            sb.append(tmp);
//
//        //우상
//        flag = true;
//        tmp = arr[row][col + n - 1];
//        for (int i = row + 0; i < n / 2; i++) {
//            for (int j = col + n / 2; j < n; j++) {
//                if (arr[i][j] != tmp) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (!flag) break;
//        }
//        if (!flag) {
//            draw(n / 2, row, col + (n / 2));
//        } else sb.append(tmp);
//
//
//        //좌하
//        flag = true;
//        tmp = arr[row + n - 1][col];
//        for (int i = row + n / 2; i < n; i++) {
//            for (int j = col + 0; j < n / 2; j++) {
//                if (arr[i][j] != tmp) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//        }
//        if (!flag) {
//            draw(n / 2, row + (n / 2), col);
//        } else sb.append(tmp);
//
//        //우하
//        flag = true;
//        tmp = arr[row + n - 1][col + n - 1];
//        for (int i = row + n / 2; i < n; i++) {
//            for (int j = col + n / 2; j < n; j++) {
//                if (arr[i][j] != tmp) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//        }
//        if (!flag) {
//            draw(n / 2, row + (n / 2), col + (n / 2));
//        } else sb.append(tmp);
//
//        sb.append(')');
    }

    public static boolean isPossible(int n, int x, int y) {
        int tmp = arr[x][y];

        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(tmp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

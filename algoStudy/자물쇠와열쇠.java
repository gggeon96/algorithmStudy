package com.kim.algoStudy;

public class 자물쇠와열쇠 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] turnRight90(int[][] arr){
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N-1-i] = arr[i][j];
            }
        }
        return tmp;
    }

    static boolean check(int[][] key, int[][] lock,int offsetX,int offsetY){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if(lock[i+offsetX][j+offsetY]==0){
                    if(key[i][j]==1) continue;
                    else return false;
                }
                if(lock[i+offsetX][j+offsetY]==1){
                    if(key[i][j]==0) continue;
                    else return false;
                }
            }
        }
        return true;
    }

    static int[][] copy(int[][] arr){
                    int [][] tmp = new int[arr.length][arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length; j++) {
                            tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = lock.length;
        M = key.length;
        map = new int[N*3][N*3];
        for (int i = 0; i < N ;i++) {
            for (int j = 0; j < N ; j++) {
                map[i+N][j+N] = lock[i][j];
            }
        }
        int[][] tmp = copy(key);
        for (int x = 0; x < N * 2; x++) {
            for (int y = 0; y < N * 2; y++) {
                for (int pos = 0; pos < 4; pos++) {
                    answer = check(tmp,map,x,y);
                    if(answer) return true;
                    tmp = turnRight90(tmp);
                }
            }
        }


        return answer;
    }

//    public static void main(String[] args) {
//        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
//        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
//        System.out.println(solution(key, lock));
//    }




}

package study;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
    static int[][] map;
    static int N;
    static int MIN;
    static int H;
    static int W;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; T >= t; t++) {
            MIN = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];

            //area초기화
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            simulate(0);
            bw.write("#" + t + " " + MIN + "\n");
            bw.flush();

        }
        bw.close();
        br.close();
    }



    //순열 짜는 함수
    static void simulate(int count) {
        //N번의 공을 던졌다면. 벽돌개수세고 최소인지 확인
        if (count == N) {
            int numberOfBrick = countBrick();
            if (MIN > numberOfBrick) MIN = numberOfBrick;
            //출력테스트
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < W; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("=====================");
            return;
        }

        //아직 아니라면. row중복순열로 선택하고 pop하고 trim해주기
        for (int j = 0; j < W; j++) {
            int[][] tmp = duplicate(map);
            int row = whereTop(j);
            pop(row, j);
            trim();
            simulate(count + 1);
            map = tmp;
        }
    }

    //터트리는 함수

    static void pop(int row, int col) {
        //유효범위안이고, 0보다크면 pop 1이 아니면 주변도 pop함수재귀
        if (isItValid(row, col)) {
            int number = map[row][col];
            map[row][col] = 0;
            //방향 4개
            for (int i = 0; i < 4; i++) {
                //해당방향의 number-1 칸만큼 pop
                for (int k = 1; k < number; k++) {
                    if (isItValid(row + (dx[i] * k), col + (dy[i] * k))) {
                        pop(row + (dx[i] * k), col + (dy[i] * k));
                    }
                }
            }
        }
    }

    //Top인덱스 찾기
    static int whereTop(int col) {
        int top = -1;
        for (int i = 0; i < H; i++) {
            if (map[i][col] == 0) continue;
            top = i;
            break;
        }
        return top; //전부다 0이면 -1리턴, 아니면 top의 인덱스 리턴
    }

    //유효범위 체크
    static boolean isItValid(int row, int col) {
        //유효범위 안이고, 0보다 큰값이 있어야함
        if (row >= 0 && col >= 0 && row < H && col < W && map[row][col] > 0) {
            return true;
        }
        return false;
    }

    //벽돌 끌어내리기
    static void trim() {
        int[][] newMap = new int[H][W]; //공백을 제거할 새로운 map
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                if (map[i][j] != 0) {
                    stack.push(map[i][j]);
                }
            }
            int idx = H - 1; //제일 바닥인덱스
            while (!stack.isEmpty()) {
                newMap[idx--][j] = stack.pop();
            }
        }
        map = newMap;
    }


    //남은 벽돌의 개수 dont need to clone
    static int countBrick() {
        int count = 0;
        for (int[] arr : map) {
            for (int x : arr) {
                if (x != 0) count++;
            }
        }
        return count;
    }

    static int[][] duplicate(int[][] map){
        int[][] newMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
               newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }
}

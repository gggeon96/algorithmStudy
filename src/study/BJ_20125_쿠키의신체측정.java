package study;

import java.io.*;

public class BJ_20125_쿠키의신체측정 {
    static int N;
    static char[][] board;
    static int[] ans; //왼팔 오른팔 허리 왼다리 오른다리
    static int heartRow=-1;
    static int heartCol=-1;
    static int[][] bodyPart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ans = new int[5];
        bodyPart = new int[][]{{0, -1}, {0, 1}, {1, 0}, {1, 0}, {1, 0}};
        board = new char[N][N]; //심장의 위치는 행,열 +1씩
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                board[i][j] = line.charAt(j);
        }

        //심장의 위치찾기
        for (int i = 0; i < N; i++) {
            if(heartRow!=-1&&heartCol!=-1) break;
            for (int j = 0; j < N; j++) {
                if(board[i][j]=='*'){
                    heartRow = i+1;
                    heartCol = j;
                }
            }
        }

        measureBodyLength(heartRow,heartCol,0,0);


        bw.write((heartRow + 1) + " " + (heartCol + 1) + "\n");
        for (int x : ans)
            bw.write(x+" ");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void measureBodyLength(int row, int col,int part,int count) {
        if(part>=5) return; //5가지 모두 구한경우
        if ( !isRange(row, col) || board[row][col] != '*') {
            ans[part] = count-1;
            if(part==2){
                measureBodyLength(heartRow+ans[2]+1,heartCol-1,part+1,1);
            } else if (part == 3) {
                measureBodyLength(heartRow+ans[2]+1,heartCol+1,part+1,1);
            } else {
                measureBodyLength(heartRow, heartCol, part + 1, 0);
            }
            return;
        }
        measureBodyLength(row+bodyPart[part][0],col+bodyPart[part][1]
                ,part,count+1);
    }

    public static boolean isRange(int row, int col) {
        if(row>=0&&row<N&&col>=0&&col<N) return true;
        return false;
    }
}

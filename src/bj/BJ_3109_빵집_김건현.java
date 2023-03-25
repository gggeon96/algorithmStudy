package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집_김건현 {
    static int R;
    static int C;
    static char[][] area;
    static boolean[][] visited;
    static int COUNT=0;
    static boolean FLAG = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        area = new char[R][C];
        visited = new boolean[R][C];
        //초기화
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                area[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            FLAG = false;
            pipeLine(i, 0, 0, i);
            if(FLAG) COUNT++;
        }
        System.out.println(COUNT);

    }

    //재귀함수
    //마지막 열에 도착했을 때 count늘려줌.
    // 근데 마지막 열에 도착하는 경우가 3개다 가능한경우 하나만 visited체크하고 나머지는 false로 놔두고 리턴
    //flag true이면 오른쪽, 오른쪽아래는 체크하지말고 바로 return
    static void pipeLine(int x, int y, int count, int startRow) {

        //기저조건
        if (y == (C - 1)) {
            FLAG=true;
            return;
        }

        //오른쪽위
        if (isPossible(x - 1, y + 1)) {
            visited[x - 1][y + 1] = true;
            pipeLine(x - 1, y + 1, count, startRow);
        }
        if(FLAG) return;

        //오른쪽
        if (isPossible(x, y + 1)) {
            visited[x][y + 1] = true;
            pipeLine(x, y + 1, count, startRow);
        }
        if(FLAG) return;

        //오른쪽아래
        if (isPossible(x + 1, y + 1)) {
            visited[x + 1][y + 1] = true;
            pipeLine(x + 1, y + 1, count, startRow);
        }
        if(FLAG) return;
    }

    static boolean isPossible(int x, int y) {
        //배열의 범위 안이고, 방문안했고 건물이 아니라면
        if (x >= 0 && x < R && y >= 0 && y < C) {
            if (area[x][y] == '.' && visited[x][y] == false) {
                return true;
            }
        }
        return false;
    }
}

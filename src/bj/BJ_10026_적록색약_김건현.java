package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026_적록색약_김건현 {
    static char[][] area;
    //	static char[][] area2;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                area[i][j] = str.charAt(j);
            }
        }
        //totalA = 색약 적용되기 전 count
        totalA += countChar('R');
        totalA += countChar('G');
        totalA += countChar('B');
        colorChange();//녹색을 모두 적색으로 바꾼다

        //색약 적용되고 난 후에는 G가 없으니 R,B만 count
        totalB += countChar('R');
        totalB += countChar('B');
        System.out.print(totalA + " " + totalB);
    }


    //해당 알파벳에 해당하는 무리의개수리턴
    static int countChar(char c) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();

        //더이상 해당하는 문자가 없을 때 까지 반복
        while (true) {
            Point p = find(c, visited);
            if (p == null) { //만약 null이라면 하나도 없는 것이니 바로 리턴
                return count;
            }
            q.offer(p);
            visited[p.row][p.col] = true;//방문체크
            count++; // 개수 늘리기

            //연결된 곳 모두 BFS
            while (!q.isEmpty()) {
                p = q.poll();
                //4방향 탐색
                for (int pos = 0; pos < 4; pos++) {
                    //옮기고자 하는 좌표
                    int x = p.row + dx[pos];
                    int y = p.col + dy[pos];
                    //배열 범위 안이고, 방문한 적이 없고, 찾고있는 문자라면
                    if (isRange(x, y) && !visited[x][y] && area[x][y] == c) {
                        //방문체크 후
                        visited[x][y] = true;
                        //큐에 담기
                        q.offer(new Point(x, y));
                    }
                }
            }
        }
    }

    //해당 하는문자의 Point반환
    static Point find(char c, boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == c && !visited[i][j]) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    //적록색약용 배열로 만들기 G-> R
    static void colorChange() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 'G') area[i][j] = 'R';
            }
        }
    }

    //범위 안인지
    static boolean isRange(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N) return true;
        return false;
    }

    //큐에 넣을 point클래스
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }

}

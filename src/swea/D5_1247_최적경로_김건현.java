package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247_최적경로_김건현 {
    //저장클래스
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int MIN;
    static int N;
    static Point company;
    static Point home;
    static Point[] customers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            MIN = Integer.MAX_VALUE;
            customers = new Point[N];
            visited = new boolean[N];

            //회사 집 고객의 좌표 저장
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int i = 0; i < N; i++) {
                customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }


            for (int i = 0; i < N; i++) {
                visited[i] = true;
                int dis = getDistance(customers[i],company);
                visit(0, dis, customers[i]);
                visited[i] = false;
            }
            System.out.println("#" + t + " " + MIN);
        }
    }



    //순열 함수
    static void visit(int count, int distance, Point recent) {
        //가지치기 조건
        if (distance >= MIN) return;

        //기저조건
        if (count == N-1) {
            //집이랑 마지막 고객사이의 거리더해주고 MIN검사
            int result = distance + getDistance(recent, home);
            MIN = Math.min(MIN, result);
            return;
        }

        //순열
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int tmp = distance + getDistance(customers[i], recent);
                visit(count + 1, tmp, customers[i]);
                visited[i] = false;
            }
        }
    }

    //두 Point간의 거리 계산 함수
    static int getDistance(Point p1, Point p2) {
        return (Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));
    }
}

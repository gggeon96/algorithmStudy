package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기_김건현 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        ArrayList<Point> points; // 집, 편의점, 페스티벌에 위치를 저장하는 배열
        boolean[][] canReach; // a-> b로 갈수있냐 없냐
        StringBuilder sb = new StringBuilder(); // 답출력용

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            points = new ArrayList<>();
            canReach = new boolean[N + 2][N + 2];

            // input받아오기
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points.add(new Point(x, y));
            }

            // 거리 1000 이하를 만족하는 두 정점을 찾음. 연결되면 true 아니면 false
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (getRange(points.get(i), points.get(j)) <= 1000) {
                        canReach[i][j] = canReach[j][i] = true;
                    }
                }
            }

            //플로이드로 계산
            for (int k = 0; k < N + 2; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        if (canReach[i][k] && canReach[k][j]) {
                            canReach[i][j] = true;
                        }
                    }
                }
            }

            //답 저장
            if(canReach[0][N+1]){
                sb.append("happy"+"\n");
            }else{
                sb.append("sad"+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 거리계산
    public static int getRange(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


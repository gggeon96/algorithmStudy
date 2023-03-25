package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ArrayList<Student> inputs = new ArrayList<>();
        //input 받아와서 ArrayList<Student>에 넣기
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            Student student = new Student(id, new int[4]);
            for (int idx = 0; idx < 4; idx++) student.likes[idx] = Integer.parseInt(st.nextToken());
            inputs.add(student);
        }

        int nearLike;
        int nearEmpty;
        int row=-1;
        int col=-1;

        //각 학생에 대해 배치
        for (Student student : inputs) {
            nearEmpty = 0;
            nearLike = 0;
            int tmpEmpty;
            int tmpLike;
            int finalRow = -1;
            int finalCol = -1;


            for (int i = N-1; i >= 0; i--) {
                for (int j = N-1; j >= 0; j--) {
                    if (map[i][j] != 0) continue;
                    row=i;col=j;

                    tmpLike = getNearLike(i, j, student.likes);
                    tmpEmpty = getNearEmpty(i, j);
                    //그냥 더 크다면 무조건 갱신
                    if (tmpLike > nearLike) {
                        nearLike = tmpLike;
                        nearEmpty = tmpEmpty;
                        finalRow = i;
                        finalCol = j;
                    } else if (tmpLike == nearLike) {
                        if (tmpEmpty > nearEmpty) {
                            nearLike = tmpLike;
                            nearEmpty = tmpEmpty;
                            finalRow = i;
                            finalCol = j;
                        }
                        else if(tmpEmpty==nearEmpty){
                            finalRow = i;
                            finalCol = j;
                        }
                    }

                }
            }
            if(finalRow==-1&&finalCol==-1) map[row][col] = student.id;
            else map[finalRow][finalCol] = student.id;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("===========");
        }
        //만족도 구하기
        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Student student : inputs) {
                    if(student.id==map[i][j]){
                        int num = getNearLike(i,j, student.likes);
                        if(num==1)score+=1;
                        else if(num==2) score+=10;
                        else if(num==3) score+=100;
                        else if(num==4) score+=1000;
                        break;
                    }
                }
            }
        }
        System.out.println(score);


    }

    static class Student {
        int id;
        int[] likes;

        public Student(int id, int[] favs) {
            this.id = id;
            this.likes = favs;
        }
    }

    /*범위 체크*/
    static boolean isRange(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N) return true;
        return false;
    }

    /*해당 칸 주변에 좋아하는 학생의 수 리턴 */
    static int getNearLike(int row, int col, int[] likes) {
        int cnt = 0;
        int nx;
        int ny;
        for (int pos = 0; pos < 4; pos++) {
            nx = row + dx[pos];
            ny = col + dy[pos];
            //범위안이면 좋아하는 학생인지 검사
            if (isRange(nx, ny)) {
                for (int like : likes) {
                    if (map[nx][ny] == like) cnt++;
                }
            }
        }
        return cnt;
    }

    /*해당 칸 주변의 빈 곳의 개수 리턴*/
    static int getNearEmpty(int row, int col) {
        int cnt = 0;
        int nx;
        int ny;
        for (int pos = 0; pos < 4; pos++) {
            nx = row + dx[pos];
            ny = col + dy[pos];
            //범위안이면 좋아하는 학생인지 검사
            if (isRange(nx, ny)) {
                if (map[nx][ny] == 0) cnt++;
            }
        }
        return cnt;
    }


}

package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class 헌터 {
    static int N;
    static int[][] map;
    static int MIN;
    static int SIZE;
    static Monster[] monsters;
    static List<Monster> monList;
    static Home[] homes;
    static Point[] points;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            MIN = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            monsters = new Monster[4];
            homes = new Home[4];
            int homeIdx = 0;
            int monsterIdx = 0;

            //초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    //집이라면
                    if(n<0){
                        homes[homeIdx++] = new Home(i, j, -n,false);
                    }else if(n>0){
                        monsters[monsterIdx++] = new Monster(i,j,n);
                    }
                }
            }
            SIZE = (monsterIdx)*2; //몬스터 개수
            points = new Point[SIZE];
            visited = new boolean[SIZE];
            int pointIdx = 0;
            for(int i=0;i<SIZE/2;i++){
                points[i] = monsters[i];
            }
            for(int i=SIZE/2;i<SIZE;i++){
                points[i] = homes[i];
            }
            for(Monster m:monsters){
                System.out.println(m.id+" "+m.col+" "+m.row);
            }
            System.out.println("SIZE" + SIZE);


            for(Point p:points){
                if(p instanceof Home) System.out.println("Home num "+((Home) p).id+"/ row col clear"+p.row+" " + p.col+" "+((Home) p).isClear);
                else if(p instanceof Monster) System.out.println("Monster num "+((Monster) p).id +"/ row col"+p.row+" " + p.col);
            }
            Point[] tmp = new Point[SIZE];
//            dfs(0,tmp);







            System.out.println("#"+t+" "+MIN);
        }
    }

    static void dfs(int idx,Point[] arr){
        //종료조건
        if(idx==SIZE){
            int sum = getSum(arr);
            if(sum<MIN) MIN = sum;
            return;
        }

        for(int i=0;i<SIZE;i++){
            //방문안했다면
            if(!visited[i]){
                //만약 집이라면 -> 몬스터 퇴치 확인
                if(points[i] instanceof Home){
                    //몬스터 퇴치 확인
                    if(((Home) points[i]).isClear){
                        //퇴치 되었으면 배열에 넣기
                        visited[i] = true;
                        arr[idx] = points[i];
                        dfs(idx+1,arr);
                        visited[i] = false;
                    }
                }
                //집이아니면 -> 몬스터라면
                else{
                    Monster m = (Monster)points[i];
                    visited[i] = true;
                    Home home = find(m.id,points);
                    home.isClear = true;
                    arr[idx] = points[i];
                    dfs(idx+1,arr);
                    visited[i] = false;
                    home.isClear = false;
                }
            }
        }


    }

    static int getSum(Point[] arr){
        int row = 0, col = 0,sum=0;
        for (Point p : arr) {
            sum += Math.abs(row - p.row) + Math.abs(col - p.col);
            row = p.row;
            col = p.col;
        }
        return sum;
    }




    static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Monster extends Point{
        int id;

        public Monster(int row, int col, int id) {
            super(row, col);
            this.id = id;
        }
    }

    static class Home extends Point{
        int id;
        boolean isClear;

        public Home(int row, int col, int num, boolean isClear) {
            super(row, col);
            this.id = num;
            this.isClear = isClear;
        }
    }

    static Home find(int id,Point[] arr){
        for(Point p:arr){
            if(p instanceof Home){
                Home home = (Home)p;
                if( home.id == id ){
                    return home;
                }
            }
        }
        return null;
    }

    static int range(int r1,int c1,int r2,int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }



}

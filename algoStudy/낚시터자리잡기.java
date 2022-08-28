package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시터자리잡기 {
    static int[] seat;//낚시터
    static int[][] ent;//입구와 대기인원
    static int N;
    static boolean[] visited;
    static int MIN;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;T>=t;t++){
            N = Integer.parseInt(br.readLine());
            MIN = Integer.MAX_VALUE;
            seat = new int[N];
            visited = new boolean[3];
            ent = new int[3][3];
            for(int i=0;i<3;i++){
                st = new StringTokenizer(br.readLine());
                ent[i][0] = Integer.parseInt(st.nextToken())-1;
                ent[i][1] = Integer.parseInt(st.nextToken());
            }
            int[][] tmpEnt = new int[3][3]; //순열 짤
            perm(0,tmpEnt);
            System.out.println("#"+t+" "+MIN);
        }

    }

    //순열만 만들고 계산은 simulate로 넘김
    static void perm(int index,int[][] tmpEnt){
        //다 고르면 해당 조건으로 시뮬레이션
        if(index == 3){
            int[] copySeat = copy(seat);
            simulate(tmpEnt,copySeat,0);
            return;
        }
        for(int i=0;i<3;i++){
            if(!visited[i]){
                visited[i] = true;
                tmpEnt[index][0] = ent[i][0];
                tmpEnt[index][1] = ent[i][1];
                perm(index+1,tmpEnt);
                visited[i] = false;
            }
        }
    }


    //만들어지 순열로 시뮬레이션
    static void simulate(int[][] ent,int[] seat,int index){
        //종료조건. MIN갱신
        if(index == 3){
            int sum = 0;
            for(int x:seat) sum+=x;
            if(sum<MIN)MIN = sum;
            return;
        }

        int entIndex = ent[index][0]; //입구의 인덱스
        int num = ent[index][1]; //입구에 있는 사람 수
        //ent[0][] 부터 ent[2][]까지 시뮬레이션
        for(int people=0;people<num;people++){
            //입구 젤 앞이 빈다면 일단 넣고
            if(seat[entIndex]==0){
                seat[entIndex] = 1;
                continue;
            }

            //좌우 비교
            int leftDis = checkLeft(seat,entIndex);
            int rightDis = checkRight(seat,entIndex);
            if(leftDis<rightDis){
                seat[entIndex-leftDis]=leftDis+1;
            }
            else if(leftDis>rightDis){
                seat[entIndex+rightDis]=rightDis+1;
            }
            //leftDis == rightDis인 경우.
            //남은인원이 2이상일 경우 문제없음. 1명남으면 좌로분기 우로분기
            else{
                //분기해야하는 상황
                if(people==num-1){
                    int[]right = copy(seat);
                    int[]left = copy(seat);
                    right[entIndex+rightDis] = rightDis+1;
                    left[entIndex-leftDis] = leftDis+1;
                    simulate(ent, left, index+1);
                    simulate(ent, right, index+1);
                    return;
                }
                //둘다 비는데 남은사람 1아니면 어차피 차니까 그냥 넣기 아무대나
                else{
                    seat[entIndex-leftDis]=leftDis+1;
                }
            }
        }
        simulate(ent,seat,index+1);
        return;
    }

    //왼쪽 체크. 없으면 999리턴 있으면 거리 리턴
    static int checkLeft(int[] seat, int index){
        for(int dis = 1;index-dis>=0;dis++){
            if(seat[index-dis]==0){
                return dis;
            }
        }
        return 999;
    }

    //오른쪽 체크. 없으면 999리턴 있으면 거리 리턴
    static int checkRight(int[] seat, int index){
        for(int dis = 1;index+dis<N;dis++){
            if(seat[index+dis]==0){
                return dis;
            }
        }
        return 999;
    }

    //걍 카피
    static int[] copy(int[] seat){
        int[] copy = new int[N];
        for(int i=0;i<N;i++){
            copy[i] = seat[i];
        }
        return copy;
    }

}

package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20055_컨베이어벨트위의로봇_김건현 {
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Belt[] belts = new Belt[N * 2];
        int stage = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belts[i] = new Belt(Integer.parseInt(st.nextToken()), false);
        }
        int uploadPosition = 0; //올리는위치
        int downloadPosition = N-1; //내리는 위치
        while (true) {

//            System.out.print("회전 전");print(N, belts, stage, uploadPosition, downloadPosition);

            //회전 = 올리는우치 내리는 위치 바뀌는거
            uploadPosition = getBackBelt(uploadPosition,N);
            downloadPosition = getBackBelt(downloadPosition,N);

//            System.out.print("회전 후");print(N, belts, stage, uploadPosition, downloadPosition);

            //로봇 내리기
            belts[downloadPosition].robot= false;

            //로봇 한칸씩 움직이기
            for (int now = getBackBelt(downloadPosition,N); now != getBackBelt(uploadPosition,N); now = getBackBelt(now,N)) {
                int front = getFrontBelt(now,N);
                //로봇이 있으면
                if(belts[now].robot){
                    //다음칸에 로봇이 없어야하고 내구도가 1이상이라면
                    if (!belts[front].robot && belts[front].durability >= 1) {
                        belts[front].robot=true; //다음칸에 로봇 올리기
                        belts[front].durability--; //내구도 1감소
                        belts[now].robot=false; //이전에 있던 로봇 비어있음으로
                        if(front==downloadPosition){
                            belts[front].robot = false;
                        }
                    }
                }
            }

//            System.out.print("로봇 한칸씩 이동 후 ");print(N, belts, stage, uploadPosition, downloadPosition);

            //올리는위치에 로봇올리기
            if (belts[uploadPosition].durability > 0) {
                belts[uploadPosition].robot=true;
                belts[uploadPosition].durability--;
            }

//            System.out.print("로봇 올리고 ");print(N, belts, stage, uploadPosition, downloadPosition);

            if(isOver(belts, K)){
//                System.out.println("isOver called");
                break;
            }
            stage++;
        }
        System.out.println(stage);

    }

    private static void print(int N, Belt[] belts, int stage, int uploadPosition, int downloadPosition) {
        System.out.println("#LOOP"+ stage);
        int now = uploadPosition;
        for (int i = 0; i < 2 * N; i++) {
            System.out.print(belts[now]);
            if(now== uploadPosition){
                System.out.print("<< #uploadPosition= "+ uploadPosition);
            }
            if(now== downloadPosition){
                System.out.print("<< #downloadPosition= "+ downloadPosition);
            }
            System.out.println();
            now = getFrontBelt(now, N);
        }
        System.out.println("==========================");
    }

    static boolean isOver(Belt[] belts, int K) {
        int cnt = 0;
        for (Belt belt : belts) {
            if (belt.durability <= 0) {
                cnt++;
            }
        }
        if (cnt >= K) return true;
        return false;
    }

    static int getBackBelt(int n, int N) {
        if(n==0){
            return 2*N-1;
        }
        return n-1;
    }

    static int getFrontBelt(int n,int N){
       if(n==(2*N-1)){
           return 0;
       }
       return n+1;
    }
}

class Belt {
    int durability; //내구성 단어가 뭐였더라
    boolean robot; //로봇이 올라와 있는가


    public Belt(int durability, boolean robot) {
        this.durability = durability;
        this.robot = robot;
    }

    @Override
    public String toString() {
        return "{" + durability +" "+ robot + "}";
    }
}

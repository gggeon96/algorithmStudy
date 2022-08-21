package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 탑승구_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); //탑승구 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수
        int cnt = 0;
        boolean[] ports = new boolean[G]; //탑승구
        int[] airplanes = new int[P];
        for (int i = 0; i < P; i++) {
            airplanes[i] = Integer.parseInt(br.readLine())-1;//탑승구번호는 1번부터이고 ports배열은 0번부터니까 -1해주고 저장
        }

        for (int i = 0; i < P; i++) {
            int airplane = airplanes[i];
            boolean dockingSuccess = false; //확인용 flag
            for (int idx = airplane; idx >= 0; idx--) { //N번부터 0번까지 하나씩 뺴가면서 탈수있는지 체크
                if (ports[idx] == false) { //아직 도킹안되어있는 포트라면
                    ports[idx] = true; //도킹체크하고
                    dockingSuccess = true; //도킹성공했다고 플래그 설정하고
                    cnt++; //도킹한 비행기 수 ++
                    break;
                }
            }
            if(!dockingSuccess){ //도킹 못했다면 현재까지 대수 출력하고 끝
                System.out.println(cnt);
                break;
            }
        }
    }
}

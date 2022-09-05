package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행성터널 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N];
        Planet[] planets = new Planet[N];
        //parents 자기자신응로 초기화
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        //planet 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i,x, y, z);
        }


    }

    static class Planet{
        int id;
        int x;
        int y;
        int z;

        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int find(int x, int[] parents) {
        if(x!=parents[x]){
            return parents[x] = find(parents[x],parents);
        }
        return x;
    }

    static void union(int x, int y, int[] parents) {
        x = find(x, parents);
        y = find(y, parents);
        if(x>y) parents[x] = y;
        else parents[y] = x;
    }
}

package com.kim.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1238_Contact_김건현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        for (int t = 1; T >= t; t++) {
            Queue<Integer> q = new LinkedList<>(); //BFS를 위한 큐
            List<Integer> ansList = new ArrayList<>(); //정답리스트
            ArrayList<Integer>[] list = new ArrayList[101]; //학생의 수는 최대100이고 번호로 접근하니 101개 생성
            for (int i = 0; i < 101; i++) { //초기화
                list[i] = new ArrayList<>();
            }
            boolean[] visited = new boolean[101];
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//24
            int start = Integer.parseInt(st.nextToken()); //2
            st = new StringTokenizer(br.readLine());
            int from;
            int to;
            //초기화
            for (int i = 0; i < (N / 2); i++) {
                from = Integer.parseInt(st.nextToken()); //인풋예시1
                to = Integer.parseInt(st.nextToken()); //인풋예시 17
                list[from].add(to); //갈수있는 간선표시
            }
            int max=0;
            q.offer(start);
            visited[start] = true;
            int level = 0;
            while (!q.isEmpty()) { //큐 종료조건
                int size = q.size(); //큐 한번 싹 비우기 (레벨단위)
//                System.out.println("=====level"+(++level));
                max =0;//레벨에서 제일 높은 수
                for (int i = 0; i < size; i++) { //현재들어있는 큐의 크기만큼
                    int n = q.poll(); //한개가져옴
                    max = Math.max(max, n);
//                    System.out.println("visit"+n);
//                    ansList.add(n);
                    for (int j = 0; j < list[n].size(); j++) { //가져온 큐의 요소에서 뻗어나가는 노드 다 추가
                        if(!visited[list[n].get(j)]){
                            visited[list[n].get(j)] = true;
                            q.offer(list[n].get(j));
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+max);


        }
    }
}

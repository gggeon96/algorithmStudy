package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 실패율 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = st.countTokens();
        int[] stage = new int[num];
        for (int i = 0; i < stage.length; i++) {
            stage[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = solution(N, stage);
        for(int x:ans) System.out.print(x+" ");

    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);
        int[] count = new int[stages.length+1];
        int totalPlayer = stages.length;
        List<Stage> stageList = new ArrayList<>();
        for (int i = 0; i < stages.length; i++) {
            count[stages[i]]++; //ex) 2번스테이지가 들어오면 count[2]가 1늘어나는 방식 계수정렬이였나이게
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] != 0) {
                stageList.add(new Stage(i, count[i] / totalPlayer));
                totalPlayer-=count[i]; //ex stage1 클리어 못한사람 한명이고 총 8명이면 totalPlayer는 7명이됨.
            }
        }
        Collections.sort(stageList);
//        for (Stage stage : stageList) {
//            System.out.print(stage.stageNum+" ");
//        }

        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNum;
        }

        return answer;
    }

    static class Stage implements Comparable<Stage>{
        int stageNum; //스테이지 번호
        double failRate; //실패율

        public Stage(int stageNum, double failRate) {
            this.stageNum = stageNum;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Stage o) {
            return this.failRate<o.failRate?-1:1;
        }
    }
}

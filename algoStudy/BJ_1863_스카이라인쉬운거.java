package com.kim.algoStudy;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1863_스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int cur = 0;
        int cnt = 0;
        Stack<Point> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //낮은건물을 만나면 이제껏 나보다 높은건물들 다 pop
            while (!stack.isEmpty() && stack.peek().y > y) {
                stack.pop();
                cnt++;
            }
            if(!stack.isEmpty() && stack.peek().y == y) continue; //높이가 같으면 push 하지 않고 넘어가기
            stack.push(new Point(x, y));
        }
        while (!stack.isEmpty()) {
            if(stack.pop().y>0) cnt++;
        }

        System.out.println(cnt);
    }

}



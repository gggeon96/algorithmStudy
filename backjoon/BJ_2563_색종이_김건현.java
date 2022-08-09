package com.kim.backjoon;

import java.util.Scanner;

public class BJ_2563_색종이_김건현 {

	static int[][] area = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //input 이 그리 많지 않으니까 스캐너를 썼습니당
		int N = sc.nextInt();
		int count = 0;
		for(int t =0;t<N;t++) {
			int col = sc.nextInt()-1;
			int row = 99-sc.nextInt(); //아래에서 부터니까 위에서 아래의 위치를 뺴주면 row값이 나옴
			fill(row,col);
		}
		for(int i= 0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(area[i][j] == 1) count++;
			}
		}
		System.out.println(count);
	}

	static void fill(int row,int col) {
		for(int i=9;i>=0;i--) {
			for(int j=0;j<10;j++) {
				area[row-i][col+j] = 1;
			}
		}
	}
}

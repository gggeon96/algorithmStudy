package swea;

import java.util.Scanner;
import java.io.FileInputStream;

class D2_2001_파리퇴치_김건현
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int rep = 1; rep <= t; rep++) {
            int sum;
            int max = Integer.MIN_VALUE;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr= new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int a=0;a<n-m+1;a++){
                for (int b=0;b<n-m+1;b++){
                    sum=0;
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            sum+=arr[i+a][j+b];
                        }
                    }
                    if(max<sum) max = sum;
                }
            }
            System.out.println("#"+rep+" "+max);


        }
	}
}
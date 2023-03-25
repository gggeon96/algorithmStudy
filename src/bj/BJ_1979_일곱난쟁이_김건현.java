package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_1979_일곱난쟁이_김건현 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] hobbit = new int[9];
		int sum =0;
		boolean flag = false;
		for(int i=0;i<9;i++) {
			hobbit[i] = Integer.parseInt(br.readLine());
			sum+= hobbit[i];
		}
		
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-hobbit[i]-hobbit[j]==100) {
					hobbit[i] = 0;
					hobbit[j] = 0;
					flag = true;
					break;
				}
				if(flag) break;
			}
		}
		Arrays.sort(hobbit);
		for(int i=2;i<8;i++) {
			bw.write(hobbit[i]+"\n");
		}
		bw.write(Integer.toString(hobbit[8]));
		bw.flush();
		bw.close();
		br.close();
	}

}

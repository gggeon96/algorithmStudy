package swea;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1228_암호문1_김건현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int T=1;T<=10;T++){

            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> list  = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            String[] commands = new String[M];
            st = new StringTokenizer(br.readLine(),"I");//I를 기준으로 명령어 분리
            for (int i = 0; i < M; i++) {
                commands[i] = st.nextToken();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(commands[i]);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] s = new int[y]; //넣을 숫자들
                for(int j=0;j<y;j++){
                    s[j] = Integer.parseInt(st.nextToken());
                }
                for(int k=x,idx =0;idx<y&&k<N;k++){
                    list.add(k,s[idx++]);
                }
            }
            bw.write("#"+T+" ");
            for (int k = 0; k < 10; k++) {
                bw.write(list.get(k)+" ");
            }

            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();

    }
}

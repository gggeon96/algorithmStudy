package study;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            int T = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 20; j++) {
                int height = Integer.parseInt(st.nextToken());
                //제일 뒤에서부터 몇번쨰인지 계산
                int cnt = 0; //어디에 들어갈 것인지
                for (int k = list.size() - 1; k >= 0; k--) {
                    if(list.get(k)>height) cnt++;
                    else break;
                }
                list.add(height);
                list.sort(Integer::compareTo);
                ans+=cnt;
            }
            bw.write(T+" "+ans+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}

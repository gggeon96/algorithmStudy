package study;

import java.io.*;

public class BJ_20437_문자열게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //init
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int[] count = new int['z' - 'a' + 1];
            for (int i = 0; i < str.length(); i++) count[str.charAt(i) - 'a']++; //단어의 알파벳 개수 증가
            for (int idx = 0; idx < str.length(); idx++) {
                if (count[str.charAt(idx) - 'a']-- >= K) { //K보다 크거나 같으면 뒤를 살핀다
                    int charCnt = 0; //우선 한개 부터 시작
                    for (int i = idx; i < str.length(); i++) { //idx 다음 글자부터 개수를센다
                        if (str.charAt(i) == str.charAt(idx)) charCnt++;
                        if (charCnt == K) {
                            max = Math.max(max, i - idx + 1);
                            min = Math.min(min, i - idx + 1);
                            break;
                        }
                    }
                }
            }
            bw.write((min == Integer.MAX_VALUE||max==Integer.MIN_VALUE )? "-1" : (min + " " + max));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

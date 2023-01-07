package com.kim.algoStudy;

import java.io.*;
import java.util.stream.Stream;

public class BJ_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] howMany = new int['z'-'a'+1];
        int max = -1;
        int index = 0;
        for (char c : input.toCharArray()) {
            c = Character.toLowerCase(c);
            howMany[c-'a']++;
        }
        for (int i =0;i<('z'-'a'+1);i++) {
            if(max<howMany[i]) {
                max = howMany[i];
                index = i;
            } else if (max == howMany[i]) {
                index = -1;
            }
        }

        bw.write(index==-1?'?':(char)('A'+index));
        bw.flush();

    }
}

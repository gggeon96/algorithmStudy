package com.kim.algoStudy;

import java.io.*;
import java.util.*;

public class BJ_20920_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Word> words = new ArrayList<>();
        HashMap<String, Word> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if(str.length()<M) continue; //M보다 짧으면

            //없으면
            if (map.get(str)==null) {
                map.put(str, new Word(1,str));
            }else{
                map.get(str).count++;
            }

        }


        for (String key : map.keySet()) {
            Word word = map.get(key);
            words.add(word);
        }

        words.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.count==o2.count){
                    if(o1.word.length()==o2.word.length()){
                        return o1.word.compareTo(o2.word);
                    }
                    return o2.word.length() - o1.word.length();
                }
                return o2.count - o1.count;
            }
        });

        for (Word word : words) {
            bw.write(word.word+'\n');
        }
        bw.flush();
        bw.close();
        br.close();

    }
    static class Word{
        int count;
        String word;

        public Word(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }
}

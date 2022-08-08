package com.kim.swea;

import java.io.*;
import java.util.Stack;

public class D4_1218_괄호짝짓기_김건현 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\KIMSTUDY\\input.txt");
        System.setIn(new FileInputStream(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for (int t = 1; T >= t; t++) {
            Stack<Character> st = new Stack<>();
            int length = Integer.parseInt(br.readLine());
            int ans = 1;
            int count = 0;
            String str = br.readLine();

            for (char c : str.toCharArray()) {
                if(ans == 0) break;
                switch (c){
                    //여는 괄호를 만나면 스택에 푸시해주깅
                    case ('('):
                    case ('{'):
                    case ('['):
                    case ('<'):
                        st.push(c);
                        break;
                    //default는 모두 닫는 괄호를 만났을때
                    //닫는 괄호를 만났을때는 스택 제일위의 괄호와 짝이 맞는지 비교.
                    //닫는 괄호를 만났는데 스택이 비어있으면 그것또한 실패케이스
                    default:
                        if(st.isEmpty()){
                            ans = 0;
                            break;
                        }else{
                            char tmp = st.pop();
                            if(tmp == c-1 || tmp==c-2){
                                count++;
                                break;
                            }
                            ans = 0;
                        }
                }
            }
            //만약 다 끝났는데도 스택이 비어있지않으면 실패케이스
            if(!st.isEmpty()) ans = 0;
//            System.out.println("#"+t+" "+ans);

            System.out.println("#"+t+" "+ans+" 짝이맞는 괄호개수: "+count);
        }
    }
}

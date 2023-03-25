package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//그냥 split 사용 : 문자열말고 메모리가 폭.발
//strArray에서 한글자씩 가져오면서 bomb여부 검사 bomb이면 터뜨리고 idx - bomb.length
public class BJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine(); //폭발문자열

        char[] arr = new char[str.length()]; //bomb없으면 str.length
        int idx = 0; //배열에 글자가 들어갈 인덱스
        for (int i = 0; i < str.length(); i++) {
            arr[idx] = str.charAt(i);
//            System.out.println("LOOP"+i+" index:"+idx);
//            print(arr);
            if(isIt(arr,idx,bomb)) idx -= bomb.length(); //폭발문자열이면 그만큼 없애고 계속 진행
            idx++;
        }

        String ans = String.valueOf(arr,0,idx); //0부터 마지막 idx까지. idx보다 큰 인덱스에 값이 저장되었다가 bomb됐을수도 잇으니 idx까지만 가져오기
        System.out.println(ans.length()>0?ans:"FRULA"); //FURLA 혹은 ans출력
    }
//    static void print(char[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
//        System.out.println();
//    }

    private static boolean isIt(char[] arr, int idx, String bomb) {
        //길이 bomb보다 짧으면 검사안하고 false returnt
        if (idx < bomb.length()-1) return false; //bomb.length - 1 이여야 한다....
        for (int i = 0; i < bomb.length(); i++) {
            if(bomb.charAt(i) != arr[idx - bomb.length() + 1 + i]) return false; //idx-bomb.length()+1 == bomb가능성있는 첫번째 글자
        }
        return true;
    }
}


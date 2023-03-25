package study;

import java.io.*;
import java.util.*;

/* 최단거리 => BFS?
* 거리는 맨해튼 거리
* 계단은 1분후 아래칸, 동시에 3명만 나머지는 대기(매 분마다 계단에 있는 인원 체크)(계단인원 큐에넣기?)
* 계단은 도착시간 순서대로 pq
*
* 사람들 어디로 가냐. 조합? 계단 2개 고정이니 가능할듯
* */
public class SWEA_2383_점심식사시간 {
    static int N;
    static ArrayList<Person> pList;
    static ArrayList<Person> stairAList;
    static ArrayList<Person> stairBList;
    static Point stairA;
    static Point stairB;
    static Person[] persons;
    static int population;
    static int MIN;
    static int stairAcost;
    static int stairBcost;
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //테케50개니까 System.out.prinln보다는 BufferdWriter사용
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        //forEach testCase
        for (int t = 1; T >= t; t++) {
            N = Integer.parseInt(br.readLine());
            MIN = Integer.MAX_VALUE;
            stairA = null;
            stairB = null;
            stairAcost = -1;
            stairBcost = -1;
            stairAList = new ArrayList<>();
            stairBList = new ArrayList<>();
            pList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    if(n==1){
                        pList.add(new Person(i,j));
                    }else if(n>1){
                        if(stairA==null){
                            stairA = new Point(i, j);
                            stairAcost = n;
                        }else{
                            stairB = new Point(i, j);
                            stairBcost = n;
                        }
                    }
                }
            }
            //test
//            System.out.println("persons");
//            for(Person p:pList){
//                System.out.println(p.row+" "+p.col);
//            }
//
//            System.out.println("stairs");
//            System.out.println(stairA.row+"/"+stairA.col);
//            System.out.println(stairB.row+"/"+stairB.col);



            population = pList.size(); //사람 인원수는 input으로 안주어짐
            subset(0);

            bw.write("#"+t+" "+MIN+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    //다시생각해보니 부분집합.
    static void subset(int idx){


        if(idx == population){
//            System.out.println("#ALIst");
//            for(Person p: stairAList){
//                System.out.println(p.row+" "+p.col);
//            }
//
//            System.out.println("#BLIst");
//            for(Person p: stairBList){
//                System.out.println(p.row+" "+p.col);
//            }
//            System.out.println("=---------------------");


//            System.out.println();
            int time = simulate();
            MIN = Math.min(MIN, time);
            return;
        }
        stairAList.add(pList.get(idx));
        //test
//        System.out.println("Alist add idx = "+ idx);
        subset(idx+1);
        stairAList.remove(stairAList.size()-1);
//        System.out.println("Alist remoce idx = "+ idx);

        stairBList.add(pList.get(idx));
        //test
//        System.out.println("Blist add idx = "+ idx);
        subset(idx+1);
//        System.out.println("Blist remoce idx = "+ idx);
        stairBList.remove(stairBList.size()-1);

    }
    //도착시간 구하기
    static void arrivalTime( ArrayList<Person> cloneA, ArrayList<Person> cloneB){
        for(Person p: cloneA){
            p.arrivalTime = Math.abs(p.row-stairA.row)+Math.abs(p.col-stairA.col);
        }

        for(Person p: cloneB){
            p.arrivalTime = Math.abs(p.row-stairB.row)+Math.abs(p.col-stairB.col);
        }
    }

    static int simulate(){

        //도착시간 순서대로 정렬
        ArrayList<Person> cloneA = (ArrayList<Person>) stairAList.clone();
        ArrayList<Person> cloneB = (ArrayList<Person>) stairBList.clone();
        arrivalTime(cloneA,cloneB);
        Collections.sort(cloneA);
        Collections.sort(cloneB);
//        Queue<Person> AQ = new LinkedList<>();
//        Queue<Person> BQ = new LinkedList<>();
        int timeA = 0;
        int timeB = 0;


        for (int i = 3; i < cloneA.size(); i++) {
            if (cloneA.get(i).arrivalTime - cloneA.get(i - 3).arrivalTime < stairAcost) {
                cloneA.get(i).arrivalTime = stairAcost+ cloneA.get(i - 3).arrivalTime;
            }
        }
        for (int i = 3; i < cloneB.size(); i++) {
            if (cloneB.get(i).arrivalTime - cloneB.get(i - 3).arrivalTime < stairBcost) {
                cloneB.get(i).arrivalTime = stairBcost+ cloneB.get(i - 3).arrivalTime;
            }
        }

        if(cloneA.size()>0){
            timeA = cloneA.get(cloneA.size()-1).arrivalTime+stairAcost+1;
        }
        if(cloneB.size()>0){
            timeB = cloneB.get(cloneB.size()-1).arrivalTime+stairBcost+1;
        }

        //test
//        System.out.println("===================================");
//        System.out.println("#ALIst");
//        for(Person p:stairAList){
//            System.out.println(p.row+" "+p.col+" "+p.arrivalTime);
//        }
//
//        System.out.println("#BLIst");
//        for(Person p:stairBList){
//            System.out.println(p.row+" "+p.col+" "+p.arrivalTime);
//        }
//        System.out.println("timeA and B ="+timeA+" "+timeB);
//        System.out.println();
        return Math.max(timeA, timeB); //둘중 오래걸리는게 최종적으로 걸린 시간
    }

}
class Point{
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Person extends Point implements Comparable<Person>{
    int arrivalTime;
    public Person(int row, int col, int arrivalTime) {
        super(row, col);
        this.arrivalTime = arrivalTime;
    }

    public Person(int row, int col) {
        super(row, col);
    }

    @Override
    public int compareTo(Person o) {
        return this.arrivalTime- o.arrivalTime;
    }
}



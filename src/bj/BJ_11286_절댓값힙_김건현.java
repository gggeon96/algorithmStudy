package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙_김건현 {
	//절대값과 숫자모두 저장해놓기 위한 클래스
	static class Number{
		int number;
		int absnumber;
		public Number(int number, int absnumber) {
			super();
			this.number = number;
			this.absnumber = absnumber;
		}
		@Override
		public String toString() {
			return Integer.toString(number);
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		//절댓값 기준으로 작은순. 절댓값이 같으면 본래의 값순 숫자를 Number클래스를 별도로 만들어 절대값과 ㅂ본래값 모두 저장
		PriorityQueue<Number> heap = new PriorityQueue<>(new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				if(o1.absnumber==o2.absnumber) {
					return o1.number-o2.number;
				}
				else return o1.absnumber-o2.absnumber;
			}
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			//0이면 제일 작은거 하나꺼내기. 비어있을땐 0을 출려가기
			if(x==0) {
				if(heap.size()==0) bw.write("0\n");
				else bw.write(heap.poll()+"\n");
			}else {
				//0이 아니면 해당 숫자 넣기
				heap.offer(new Number(x,Math.abs(x)));
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}

package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케는 10번
		for(int i=1;i<=10;i++) {
			int T = sc.nextInt();
			
			Queue<Integer> q = new LinkedList<>();
			for(int j=0;j<8;j++) {
				q.offer(sc.nextInt());
			}
			
			outer :while(true) {
				// 사이클 수
				int cycle = 1;
				while(cycle < 6) {
					// 맨앞에 숫자 a
					int a = q.poll();
					// 들어갈 숫자 b
					int b = a-cycle;
					cycle++;
					
					if(b <= 0) {
						b = 0;
						q.offer(b);
						break outer;
					}
					else {
						q.offer(b);
					}
				}
			}
			System.out.print("#"+i+" ");
			for(int j=0;j<8;j++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
			
			
		}
		
		
	}
}

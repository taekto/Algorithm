package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_3499_퍼펙트_셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			if(N%2 == 1) {
				for(int j=0;j<=N/2;j++) {
					q1.offer(sc.next());
				}
				
				for(int j=N/2+1;j<N;j++) {
					q2.offer(sc.next());
				}
			}
			else {
				for(int j=0;j<N/2;j++) {
					q1.offer(sc.next());
				}
				
				for(int j=N/2;j<N;j++) {
					q2.offer(sc.next());
				}
			}
			System.out.print("#"+i+" ");
			while(true) {
				if(!q1.isEmpty()) {
					System.out.print(q1.poll()+" ");
				}
				if(!q2.isEmpty()) {
					System.out.print(q2.poll()+" ");
				}
				if(q1.isEmpty() && q2.isEmpty()) {
					break;
				}
			}
			System.out.println();
		}
		
	}
}

package D2;

import java.util.Scanner;

public class Solution_1284_수도_요금_경쟁_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int money1 = P*W;
			int money2 = 0;
			if(W <= R ) {
				money2 = Q;
			}
			else {
				money2 = Q + (W-R)*S;
			}
			
			if(money1 > money2) {
				System.out.println("#"+i+" "+money2);
			}
			else {
				System.out.println("#"+i+" "+money1);

			}
			
			
			
		}
		
		
	}

}

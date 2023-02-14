package D2;

import java.util.Scanner;

public class Solution_1945_간단한_소인수분해 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			
			while(N != 1) {
				if(N % 2 == 0) {
					a = a+1;
					N = N/2;
				}
				else if (N % 3 == 0) {
					b = b+1;
					N = N/3;
				}
				else if(N % 5 == 0) {
					c = c+1;
					N = N/5;
				}
				else if(N % 7 == 0) {
					d = d+1;
					N = N/7;
				}
				else if(N % 11 == 0) {
					e = e+1;
					N = N/11;
				}
				
				
			}
			System.out.printf("#%d %d %d %d %d %d\n",i,a,b,c,d,e);
			
			
			
			
		}
		
		
	}

}

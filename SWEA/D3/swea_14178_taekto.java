package D3;

import java.util.Scanner;

public class swea_14178_taekto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스T
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			// N과 D 
			double N = sc.nextInt();
			double D = sc.nextInt();
			
			// 최소 갯수
			double result = Math.ceil(N/(1+2*D));
			
			
			System.out.println("#"+i+" "+(int) result);
				
			
		}
		
		
		
		
		
		
	}

}

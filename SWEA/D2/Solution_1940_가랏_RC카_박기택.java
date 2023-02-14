package D2;

import java.util.Scanner;

public class Solution_1940_가랏_RC카_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			int N = sc.nextInt();
			
			int count = 0;
			int speed = 0;
			int distance = 0;
			while(count < N) {
				int a = sc.nextInt();
				
				if(a == 1) {
					int b = sc.nextInt();
					speed += b;
				}
				else if(a == 0) {
					
				}
				else {
					int b = sc.nextInt();
					speed -= b;
				}
				if(speed <0) {
					speed = 0;
				}
				count++;
				distance = distance + speed;
			}
			
			System.out.println("#"+i+" "+distance);
			
			
			
			
			
			
		}
		
		
	}

}

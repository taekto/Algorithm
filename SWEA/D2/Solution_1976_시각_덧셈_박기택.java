package D2;

import java.util.Scanner;

public class Solution_1976_시각_덧셈_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int time;
			int minutes;
			time = a+c;
			minutes = b+d;
			
			if(minutes >= 60) {
				time += 1;
				minutes -= 60;
			}
			
			if(time > 12) {
				time -= 12;
			}
			
			System.out.println("#"+i+" "+time+" "+minutes);
			
			
			
		}
		
		
	}

}

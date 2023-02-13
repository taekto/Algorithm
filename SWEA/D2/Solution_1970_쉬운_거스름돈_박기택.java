package D2;

import java.util.Scanner;

public class Solution_1970_쉬운_거스름돈_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int money = sc.nextInt();
			System.out.println("#"+i);
			
			System.out.print(money/50000+" ");
			money = money % 50000;
			
			System.out.print(money/10000+" ");
			money = money % 10000;
			
			System.out.print(money/5000+" ");
			money = money % 5000;
			
			System.out.print(money/1000+" ");
			money = money % 1000;
			
			System.out.print(money/500+" ");
			money = money % 500;
			
			System.out.print(money/100+" ");
			money = money % 100;
			
			System.out.print(money/50+" ");
			money = money % 50;
			
			System.out.println(money/10);
			money = money % 10;
		}
		
		
	}

}

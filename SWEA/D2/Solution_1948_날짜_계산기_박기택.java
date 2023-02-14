package D2;

import java.util.Scanner;

public class Solution_1948_날짜_계산기_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i=1;i<=T;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			int day = 0;
			
			if(a == c) {
				day = d-b+1;
			}
			else {
				day = arr[a]-b+1;
				for(int j=a+1;j<c;j++) {
					day += arr[j];
				}
				day = day +d;
				
				
				
			}
			System.out.println("#"+i+" "+day);
			
			
			
		}
		
	}

}

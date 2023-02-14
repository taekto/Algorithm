import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int hours = A+B;
			if(hours >= 24) {
				hours -= 24;
			}
			
			System.out.println("#"+i+" "+hours);
			
			
		}
		
		
	}

}
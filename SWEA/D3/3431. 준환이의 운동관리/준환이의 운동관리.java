import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			if(X >= L & X <= U) {
				System.out.println("#"+i+" "+0);
			}
			else if(X < L) {
				System.out.println("#"+i+" "+(L-X));

			}
			else if(X > U) {
				System.out.println("#"+i+" "+(-1));

			}
			
			
		}
		
	}

}
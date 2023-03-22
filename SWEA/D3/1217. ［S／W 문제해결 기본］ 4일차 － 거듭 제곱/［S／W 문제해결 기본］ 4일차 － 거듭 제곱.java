import java.util.Scanner;

public class Solution {
	public static int recursive_power(int x, int n) {
		if(n == 1) return x;
		
		if(n%2 == 0) {
			int y = recursive_power(x, n/2);
			return y*y;
		}
		else {
			int y = recursive_power(x, (n-1)/2);
			return y*y*x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int trash = sc.nextInt();
			int x = sc.nextInt();
			int n = sc.nextInt();
			
			System.out.println("#"+tc+" "+recursive_power(x, n));
			
		}
	}
	
}

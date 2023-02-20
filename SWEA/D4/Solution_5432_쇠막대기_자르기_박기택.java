package D4;

import java.util.Scanner;
import java.util.Stack;

public class Solution_5432_쇠막대기_자르기_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();


		for(int i=1;i<=T;i++) {
			
			
			Stack<Character> stack = new Stack<>();
			String str = sc.next();		
			int count = 0;
			int result = 0;
			
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == '(') {
					count +=1;
				}
				else if(str.charAt(j) == ')') {
					if(str.charAt(j-1) == '(') {
						count -=1;
						result += count;
					}
					else {
						count -=1;
						result +=1;
					}
				}
				
			}
			System.out.println("#"+i+" "+result);
			

			
		}
		
		
		
	}

}

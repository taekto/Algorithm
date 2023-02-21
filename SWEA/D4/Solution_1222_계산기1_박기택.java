package D4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1222_계산기1_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			Stack<Integer> numstack = new Stack<>();
			Stack<Character> operator = new Stack<>();
			
			char[] ch = str.toCharArray();
			for(int j=0;j<ch.length;j++) {
				if(ch[j] == '+') {
					operator.push(ch[j]);
				}
				else {
					numstack.push(Integer.parseInt(String.valueOf(ch[j])));
				}
			}
			int sum = 0;
			while(true) {
				if(operator.isEmpty()) {
					break;
				}
				int b = numstack.pop();
				int a = numstack.pop();
				char op = operator.pop();
				if(op == '+') {
					sum = a+b;
					numstack.push(sum);
				}
			}
			System.out.println("#"+i+" "+sum);
			
			
			
			
		}
		
	}
}

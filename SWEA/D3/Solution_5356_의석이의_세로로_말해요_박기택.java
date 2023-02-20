package D3;

import java.util.Scanner;
import java.util.Stack;

public class Solution_5356_의석이의_세로로_말해요_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
				
			String str1 = sc.next();
			String str2 = sc.next();
			String str3 = sc.next();
			String str4 = sc.next();
			String str5 = sc.next();
			Stack<String> stack1 = new Stack<>();
			Stack<String> stack2 = new Stack<>();
			Stack<String> stack3 = new Stack<>();
			Stack<String> stack4 = new Stack<>();
			Stack<String> stack5 = new Stack<>();
			
			for(int j=str1.length()-1;j>=0;j--) {
				stack1.add(String.valueOf(str1.charAt(j)));
			}
			for(int j=str2.length()-1;j>=0;j--) {
				stack2.add(String.valueOf(str2.charAt(j)));
			}
			for(int j=str3.length()-1;j>=0;j--) {
				stack3.add(String.valueOf(str3.charAt(j)));
			}
			for(int j=str4.length()-1;j>=0;j--) {
				stack4.add(String.valueOf(str4.charAt(j)));
			}
			for(int j=str5.length()-1;j>=0;j--) {
				stack5.add(String.valueOf(str5.charAt(j)));
			}
			System.out.print("#"+i+" ");
			
			while(true) {
				if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty() && stack5.isEmpty()) {
					break;
				}
				if(!stack1.isEmpty()) {
					System.out.print(stack1.pop());
				}
				if(!stack2.isEmpty()) {
					System.out.print(stack2.pop());
				}
				if(!stack3.isEmpty()) {
					System.out.print(stack3.pop());
				}
				if(!stack4.isEmpty()) {
					System.out.print(stack4.pop());
				}
				if(!stack5.isEmpty()) {
					System.out.print(stack5.pop());
				}
				
			}
//			System.out.println(stack1);
				
		}
		
	}

}

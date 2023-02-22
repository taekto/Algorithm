package boj;

import java.util.Scanner;
import java.util.Stack;

public class boj_17413_단어_뒤집기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		// < 넣을 공간>
		StringBuilder data = new StringBuilder();
		
		StringBuilder result = new StringBuilder();
		
		
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			if(c == '>') {
				data.append(c);
				result.append(data);
				data.setLength(0);
			}
			else if(data.length() != 0) {
				data.append(c);
			}
			else if(c == '<') {
				sb.reverse();
				result.append(sb);
				sb.setLength(0);;
				data.append(c);
			}
			else if(c != ' ' && c != '<' && c != '>') {
				sb.append(c);
			}
			else if(c == ' ') {
				sb.reverse();
				result.append(sb);
				sb.setLength(0);
				result.append(c);
			}
		}
		sb.reverse();
		result.append(sb);
		
		System.out.println(result);
		
	}
}

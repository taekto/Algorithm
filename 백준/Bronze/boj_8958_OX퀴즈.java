package boj;

import java.util.Scanner;

public class boj_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String str = sc.next();
			int count = 0;
			int result = 0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == 'O') {
					count++;
					result += count;
				}
				else {
					count = 0;
				}
			}
			System.out.println(result);
		}
		
		
	}
}

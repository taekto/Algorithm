package D4;

import java.util.Scanner;

public class Solution_1218_괄호_짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			// N 값 받기
			int N = sc.nextInt();
			String str = sc.next();
			char[] ch = str.toCharArray();
			// ()
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			
			for(int j=0;j<ch.length;j++) {
				if(ch[j] == '(') {
					count1 +=1;
				}
				else if(ch[j] == ')') {
					count1 -=1;
				}
				else if(ch[j] == '[') {
					count2 +=1;
				}
				else if(ch[j] == ']') {
					count2 -=1;
				}
				else if(ch[j] == '{') {
					count3 +=1;
				}
				else if(ch[j] == '}') {
					count3 -=1;
				}
				else if(ch[j] == '<') {
					count4 +=1;
				}
				else if(ch[j] == '>') {
					count4 -=1;
				}
			}
			if(count1 == 0 && count2 == 0 && count3 == 0 && count4 == 0) {
				System.out.println("#"+i+" "+1);
			}
			else {
				System.out.println("#"+i+" "+0);
			}
			
			
		}
		
	}
}

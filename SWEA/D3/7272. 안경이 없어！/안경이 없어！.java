import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String str1 = sc.next();
			String str2 = sc.next();
			
			str1 = str1.replace("A", "1");
			str1 = str1.replace("D", "1");
			str1 = str1.replace("O", "1");
			str1 = str1.replace("P", "1");
			str1 = str1.replace("Q", "1");
			str1 = str1.replace("R", "1");
			
			str2 = str2.replace("A", "1");
			str2 = str2.replace("D", "1");
			str2 = str2.replace("O", "1");
			str2 = str2.replace("P", "1");
			str2 = str2.replace("Q", "1");
			str2 = str2.replace("R", "1");
			int check = 0;
			if(str1.length() == str2.length()) {
				for(int j=0;j<str1.length();j++) {
					if((tf(str1.charAt(j)) && tf(str2.charAt(j)))) {
						check += 1;
						continue;
					}
					if(str1.charAt(j) == str2.charAt(j)) {
						check += 1;
						continue;
					}
				}
			}
			
			
			if(check == str1.length()) {
				System.out.println("#"+i+" SAME");
			}
			else {
				System.out.println("#"+i+" DIFF");
			}
			
			
		}
	}
	public static boolean tf(char a) {
		if(a != '1' && a != 'B') return true;
		else return false;
	}
	
	public static boolean tff(char a) {
		char[] arr = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
		for(int i=0;i<arr.length;i++) {
			if(a == arr[i]) return true;
		}
		return false;
		
	}
	
}

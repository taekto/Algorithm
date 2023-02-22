import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 T
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String str = sc.next();
			
			// 현재 박수치는 사람
			int clap = 0;
			// 추가적으로 필요한 사람
			int people = 0;
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				if(Integer.parseInt(String.valueOf(c)) == 0) {
					continue;
				}
				if(j == 0) {
					clap += Integer.parseInt(String.valueOf(c));
					continue;
				}
				else if(clap + people >= j) {
					clap += Integer.parseInt(String.valueOf(c));
				}
				else if(clap+people < j) {
					people += j-clap-people;
					clap += Integer.parseInt(String.valueOf(c));
				}
			}
			System.out.println("#"+i+" "+people);
			
			
		}
		
	}
}

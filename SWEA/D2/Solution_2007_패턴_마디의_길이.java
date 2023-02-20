package D2;

import java.util.Scanner;

public class Solution_2007_패턴_마디의_길이 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String str = sc.next();
			int result = 0;
			for(int j=1;j<=10;j++) {
				str.substring(0);
				String a = str.substring(0, j);
//				System.out.println(a);
				String b = str.substring(j, j+a.length());
//				System.out.println(b);
				if(a.equals(b)) {
					result = a.length();
					break;
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}

}

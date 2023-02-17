package D3;

import java.util.Scanner;

public class Solution_1213_String_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int T = sc.nextInt();
			String inputstr = sc.next();
			String inputdata = sc.next();
			int m = inputstr.length();
			int n = inputdata.length();
			
			int result = 0;
			for(int j=0;j<n-m+1;j++) {
				int count = 0;
				for(int k=0;k<m;k++) {
					if(inputstr.charAt(k) == inputdata.charAt(k+j)) {
						count++;
					}
				}
				if(count == inputstr.length()) {
					result +=1;
				}				
			}
			System.out.println("#"+i+" "+result);
			
			
		}
		
		
	}

}

package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_11315_오목_판정_박기택_fail {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N =sc.nextInt();
			
			List<List<String>> list = new ArrayList<>();
			
			for(int j=0;j<N;j++) {
				List<String> input = new ArrayList<>();
				String str = sc.next();
				
				for(int k=0;k<N;k++) {
					input.add(String.valueOf(str.charAt(k)));
				}
				list.add(input);
			}
			
			
			int resultcount = 0;
			
			for(int j=0;j<N;j++) {
				int count = 0;
				for(int k=0;k<N;k++) {
					if(list.get(j).get(k).equals("o")) {
						count +=1;
					}
				}
				if(count >= 5) {
					resultcount +=1;
				}
				
			}
			
			for(int j=0;j<N;j++) {
				int count = 0;
				for(int k=0;k<N;k++) {
					if(list.get(k).get(j).equals("o")) {
						count +=1;
					}
				}
				if(count >= 5) {
					resultcount +=1;
				}
				
			}
			
			
			int acount = 0;
			for(int j=0;j<N;j++) {
				if(list.get(j).get(j).equals("o")) {
					acount += 1;
				}
			}
			
			if(acount >= 5) {
				resultcount +=1;
			}
			
			int bcount = 0;
			for(int j=0;j<N;j++) {
				if(list.get(j).get(N-j-1).equals("o")) {
					bcount += 1;
				}
			}
			
			if(bcount >= 5) {
				resultcount +=1;
			}
			
			if(resultcount >= 1) {
				System.out.println("#"+i+" "+"YES");
			}
			else {
				System.out.println("#"+i+" "+"NO");
			}
			
			
			
		}
		
		
		
		
	}

}

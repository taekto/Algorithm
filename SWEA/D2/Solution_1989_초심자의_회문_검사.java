package D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1989_초심자의_회문_검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			String str = sc.next();
			List<String> list = new ArrayList<>();
			
			for(int j=0;j<str.length();j++) {
				list.add(String.valueOf(str.charAt(j)));
			}
			
			System.out.println(list);
			int count = 0;
			if(list.size() > 1) {
				if(list.get(0).equals(list.get(list.size()-1)) ) {
					list.remove(list.size()-1);
					list.remove(0);
					count +=1;
				}
				else {
					count = 0;
				}
				
			}
			else {
				
			}
			if( count>0) {
				System.out.println("#"+i+" "+1);
			}
			else {
				System.out.println("#"+i+" "+0);
			}
			
		}
		
		
	}

}

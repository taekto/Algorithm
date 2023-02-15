package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_4406_모음이_보이지_않는_사람_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			List<String> list = new ArrayList<>();
			
			String str = sc.next();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == 'o' | str.charAt(j) == 'a' | str.charAt(j) == 'e' | str.charAt(j) == 'i' | str.charAt(j) == 'u' ) {
					
				}
				else {
					list.add(String.valueOf(str.charAt(j)));
				}
				
			}
			System.out.print("#"+i+" ");
			
			for(int j=0;j<list.size();j++) {
				System.out.print(list.get(j));
			}
			
			System.out.println();
		}
		
	}

}

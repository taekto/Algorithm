package D2;

import java.util.HashSet;
import java.util.Scanner;

public class Solution_1288_새로운_불면증_치료법_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			int N = sc.nextInt();
			HashSet<Integer> arr = new HashSet<>();
			int a = 1;
			
			while(arr.size()<10) {
				int data = N*a;
				
				String str = String.valueOf(data);
				
				for(int j=0;j<str.length();j++) {
					arr.add(Integer.parseInt(String.valueOf(str.charAt(j))));
					
				}
				a += 1;

//				System.out.println(arr);

			}
//			System.out.println(arr);
			
			System.out.println("#"+i+" "+((a-1)*N));
			
			
			
			
			
			
		}
		
		
		
	}

}

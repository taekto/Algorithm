package D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1946_간단한_압축_풀기_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			
			List<String> arr = new ArrayList<>();
			for(int j=0;j<N;j++) {
				String str = sc.next();
				int times = sc.nextInt();
				
				for(int k=0;k<times;k++) {
					arr.add(str);
				}
				
				
			}
			System.out.println("#"+i);
			
			for(int j=0;j<arr.size();j++) {
				System.out.print(arr.get(j));
				if((j+1) % 10 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			
			
		}
		
		
	}

}

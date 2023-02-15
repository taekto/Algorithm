package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_10505_소득_불균형_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			
			List<Integer> list = new ArrayList<>();
			int sum =0;
			
			for(int j=0;j<N;j++) {
				list.add(sc.nextInt());
			}
			
			for(int j=0;j<N;j++) {
				sum += list.get(j);
			}
			
			int avg = sum/list.size();
			
			int count = 0;
			for(int j=0;j<N;j++) {
				if(list.get(j) <= avg) {
					count += 1;
				}
			}
			
			System.out.println("#"+i+" "+count);
			
			
			
			
		}
		
		
	}

}

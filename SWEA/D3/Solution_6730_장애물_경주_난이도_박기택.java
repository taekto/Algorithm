package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_6730_장애물_경주_난이도_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			
			List<Integer> ascend = new ArrayList<>();
			List<Integer> descend = new ArrayList<>();
			ascend.add(0);
			descend.add(0);
			int[] arr = new int[N];
			for(int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
			}
			
			
			for(int j=0;j<N-1;j++) {
				if(arr[j+1]-arr[j]>=0) {
					ascend.add(arr[j+1]-arr[j]);

				}
				if( arr[j]-arr[j+1] >= 0) {
					descend.add(Math.abs(arr[j]-arr[j+1]));
				}	
			}
			descend.sort(null);
			ascend.sort(null);
			
			System.out.println("#"+i+" "+ascend.get(ascend.size()-1)+" "+(descend.get(descend.size()-1)));
			
			
			
			
		}
		
	}

}

package D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1940_가랏_RC카_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			
			List<Integer> arr = new ArrayList<>();
			
			for(int j=0;j<N;j++) {
				arr.add(Math.abs(sc.nextInt()));
			}
			
			arr.sort(null);
			int count = 0;
			for(int j=0;j<arr.size();j++) {
				if(arr.get(j) == arr.get(0)) {
					count += 1;
				}
				else {
					break;
				}
			}
			System.out.println("#"+i+" "+arr.get(0)+" "+count);
			
			
		}
		
		
		
	}

}

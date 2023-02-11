package D2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class swea_1859_taekto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			int N = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			
			for(int j=0;j<N;j++) {
				arr.add(sc.nextInt());
			}
			
			Collections.reverse(arr);
			
			long profit = 0;
			int count = 0;
			
			while(true) {
				int max = Collections.max(arr);
				if(arr.size() >= 1) {
					if(arr.get(arr.size()-1) != max) {
						profit -= arr.get(arr.size()-1);
						arr.remove(arr.size()-1);
						count += 1;
					} else {
						profit += arr.get(arr.size()-1)*count;
						arr.remove(arr.size()-1);
						count = 0;
						if(arr.size() >= 1) {
							max = Collections.max(arr);
						}
						else {
							break;
						}
						
					}
				} else {
					break;
				}
			
			
			
			
				
			}
			if(profit<0) {
				System.out.println("#"+i+" "+0);
			} else {
				System.out.println("#"+i+" "+profit);

			}
			
		}
	}

}
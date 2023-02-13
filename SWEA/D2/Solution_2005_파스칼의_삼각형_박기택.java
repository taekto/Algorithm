package D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_2005_파스칼의_삼각형_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int Num = 2;
			
			List<List<Integer>> allarr = new ArrayList<>();
			List<Integer> firstline = new ArrayList<>();
			firstline.add(1);
			
			allarr.add(firstline);
//			System.out.println(allarr);
			
			for(int j=1;j<N;j++) {
				List<Integer> list = new ArrayList<>();
				for(int k=0;k<Num;k++) {
					if(k == 0) {
						list.add(1);

					}
					else if(k == Num-1) {
						list.add(1);
					}
					else {
						list.add(allarr.get(Num-2).get(k)+allarr.get(Num-2).get(k-1));
					}
					
					
				}
				allarr.add(list);
//				System.out.println(allarr);
				
				Num++;
				
			}
			System.out.println("#"+i);
			for(int j=0;j<allarr.size();j++) {
				for(int k=0;k<allarr.get(j).size();k++) {
					System.out.print(allarr.get(j).get(k)+" ");
				}
				System.out.println();
			}
			
			
		}
		
	}

}

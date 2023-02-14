package D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1961_숫자_배열_회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 T
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			// N값 받기(NxN) 배열
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			// 90 도 회전	
			List<List> allarr = new ArrayList<>();
			
			for(int j=0;j<N;j++) {
				List<Integer> data = new ArrayList<>(); 
				for(int k=N-1;k>=0;k--) {
					data.add(arr[k][j]);
				}
				allarr.add(data);
			}
			
			for(int j=N-1;j>=0;j--) {
				List<Integer> data = new ArrayList<>(); 
				for(int k=N-1;k>=0;k--) {
					data.add(arr[j][k]);
				}
				allarr.add(data);
			}
			
			for(int j=N-1;j>=0;j--) {
				List<Integer> data = new ArrayList<>(); 
				for(int k=0;k<N;k++) {
					data.add(arr[k][j]);
				}
				allarr.add(data);
			}
//			System.out.println(allarr);
			
			System.out.println("#"+i);
			for(int j=0;j<N;j++) {
				for(int k=0;k<(N*3);k++) {
					if((k+N)%N == j) {
						for(int a=0;a<allarr.get(k).size();a++) {
							System.out.print(allarr.get(k).get(a));
						}
						System.out.print(" ");
						
					}
					
				}
				System.out.println();
			}
			
			

			
			
			
			
		}
	}

}

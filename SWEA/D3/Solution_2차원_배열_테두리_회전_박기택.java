package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2차원_배열_테두리_회전_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int num = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][M];
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			
			for(int a=0;a<K;a++) {
				int[][] newarr = new int[N][M];
				for(int j=0;j<N;j++) {
					for(int k=0;k<M;k++) {
						if(j == 0 && k+1 < M) {
							newarr[j][k+1] = arr[j][k];
						}
						else if(k == M-1 && j+1 < N) {
							newarr[j+1][k] = arr[j][k];
						}
						else if(j == N-1 && k-1 >= 0) {
							newarr[j][k-1] = arr[j][k];
						}
						else if(k == 0 && j-1 >= 0) {
							newarr[j-1][k] = arr[j][k];
						}
						else {
							newarr[j][k] = arr[j][k];
						}
					}
				}
				arr = newarr;
			}
			
			System.out.println("#"+i);
			for(int d=0;d<N;d++) {
				for(int e=0;e<M;e++) {
					System.out.print(arr[d][e]+" ");
				}
				System.out.println();
			}
			

		}
		
		
		
	}
	


}

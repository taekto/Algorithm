package D2;

import java.util.Scanner;

public class Solution_1979_어디에_단어가_들어갈_수_있을까_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int result = 0;
			
			for(int j=0;j<N;j++) {
				int count = 0;
				for(int k=0;k<N;k++) {
					if(arr[j][k] == 1) {
						count += 1;
						if(k == N-1 && count == K) {
							result +=1;
						}
					}
					else {
						if(count == K) {
							result += 1;
						}
						count = 0;
						
					}
					
				}
			}
			
			
			for(int j=0;j<N;j++) {
				int count = 0;
				for(int k=0;k<N;k++) {
					if(arr[k][j] == 1) {
						count += 1;
						if(k == N-1 && count == K) {
							result +=1;
						}
					}
					else {
						if(count == K) {
							result += 1;
						}
						count = 0;
						
						
					}
					
				}
			}
			
			System.out.println("#"+i+" "+result);
			
			
		}
		
	}

}

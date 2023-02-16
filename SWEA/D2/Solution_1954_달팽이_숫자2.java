package D2;

import java.util.Scanner;

public class Solution_1954_달팽이_숫자2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			

			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k] = 0;
				}
			}
			
			int dr = 0;
			int dc = 0;
			
			int index = 2;
			int x = 0;
			int y = 0;
			
			arr[0][0] = 1;
			
			int xtimes = N;
			int ytimes = N-1;
			
			while(xtimes != 0 && ytimes != 0) {
				
				while(true) {
					if(x+1 < N-1 && x+1 >= 0 && arr[y][x+1] != 0) {
						xtimes -= 1;
						break;
					}
					
					arr[y][x+1] = index;
					x = x+1;
					index++;
				}
				
				while(true) {
					if(x+1 < N-1 && x+1 >= 0 && arr[y][x-1] != 0) {
						xtimes -= 1;
						break;
					}
					
					arr[y][x-1] = index;
					x = x-1;
					index++;
				}
				
				
				while(true) {
					if(x+1 < N-1 && x+1 >= 0 &&  arr[y+1][x] != 0) {
						ytimes -= 1;
						break;
					}
					
					arr[y+1][x] = index;
					y = y+1;
					index++;
				}
				
				while(true) {
					if(x+1 < N-1 && x+1 >= 0 && arr[y-1][x] != 0) {
						ytimes -= 1;
						break;
					}
					arr[y+1][x] = index;
					y = y+1;
					index++;
				}
	
			}
			
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
			
			
		
		
		
		}
	}

}

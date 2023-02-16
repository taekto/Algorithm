package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1954_달팽이_숫자_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			
			int index = 2;
			int x = 0;
			int y = 0;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k] = 0;
				}
			}
			
			arr[0][0] = 1;

			int gear = 0;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(x < N-1 && arr[y][x+1] == 0) {
						arr[y][x+1] = index;
						x++;
						index++;
						continue;
					}
					if(y < N-1 && arr[y+1][x] == 0) {
						arr[y+1][x] = index;
						y++;
						index++;
						continue;
					}
					if(x > 0 && arr[y][x-1] == 0) {
						arr[y][x-1] = index;
						x--;
						index++;
						continue;
					}
					while(y > 0 && arr[y-1][x] == 0) {
						arr[y-1][x] = index;
						y--;
						index++;
					}
//					else if(y >= 0 && arr[y-1][x] == 0) {
//						arr[y-1][x] = index;
//						y--;
//						index++;
//						continue;
//					}
				}
			}
			
			System.out.println("#"+i);
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
			
			
			
			
		}
		
		
		
	}

}

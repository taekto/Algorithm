package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1954_달팽이_숫자 {
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
			
			System.out.println(Arrays.toString(arr[0]));
			System.out.println(Arrays.toString(arr[1]));
			System.out.println(Arrays.toString(arr[2]));
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					for(int m=0;m<dr.length;m++) {
						
						if(y+dr[m] >= 0 && y+dr[m] <= N-1 && x+dc[m] >= 0 && x+dc[m] <= N-1) {
							if(arr[y+dr[m]][x+dc[m]] == 0) {
								arr[y+dr[m]][x+dc[m]] = index;
								y = y+dr[m];
								x = x+dc[m];
								index++;
								break;
							}

						}
						
					}
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

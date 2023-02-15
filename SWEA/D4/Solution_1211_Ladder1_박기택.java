package D4;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class Solution_1211_Ladder1_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int goal = 0;
			
			for(int j=0;j<100;j++) {
				if(arr[99][j] == 2) {
					goal = j;
				}
				
			}
			int x = 0;
			int y = 0;
			int result = 0;
			
			while(true) {
				if(99+y == 0) {
					result = goal+x;
					break;
				}
			
				if(  (goal+x-1) >= 0 && arr[99+y][goal+x-1] == 1  ) {
					arr[99+y][goal+x] = 0;
					x -= 1;
				}
				else if((goal+x+1) < 100 && arr[99+y][goal+x+1] == 1 ) {
					arr[99+y][goal+x] = 0;
					x += 1;
				}
				else{
					y -= 1;
				}

			}
			System.out.println("#"+i+" "+result);
		}
		
	}

}


package boj;

import java.util.Arrays;
import java.util.Scanner;

public class jungol_1733_오목 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[20][20];
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
//		for(int i=0;i<20;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		// 가로줄 번호, 세로줄 번호
		int x = 0;
		int y = 0;
		int winner = 0;
		// 가로탐색
		outer :for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				int count1 = 0;
				int count2 = 0;
				for(int k=-2;k<=2;k++) {
					int nr = i+k;
					int nc = j+k;
					if(nc>=0 && nc<20) {
						if(arr[i][nc] == 1) {
							count1++;
						}
						else if(arr[i][nc] == 2) {
							count2++;
						}
					}
				}
				if(count1 == 5) {
					x = j-2;
					y = i;
					winner = 1;
					break outer;
				}
				if(count2 == 5) {
					x = j-2;
					y = i;
					winner = 2;
					break outer;
				}
			}
		}
		
		// 세로탐색
		outer :for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				int count1 = 0;
				int count2 = 0;
				for(int k=-2;k<=2;k++) {
					int nr = i+k;
					int nc = j+k;
					if(nr>=0 && nr<20) {
						if(arr[nr][j] == 1) {
							count1++;
						}
						else if(arr[nr][j] == 2) {
							count2++;
						}
					}
				}
				if(count1 == 5) {
					x = j;
					y = i-2;
					winner = 1;
					break outer;
				}
				if(count2 == 5) {
					x = j;
					y = i-2;
					winner = 2;
					break outer;
				}
			}
		}
		
		//오른쪽 아래로 내려가는 대각선 탐색
		outer :for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				int count1 = 0;
				int count2 = 0;
				for(int k=-2;k<=2;k++) {
					int nr = i+k;
					int nc = j+k;
					if(nr>=0 && nr<20 && nc>=0 && nc<20) {
						if(arr[nr][nc] == 1) {
							count1++;
						}
						else if(arr[nr][nc] == 2) {
							count2++;
						}
					}
				}
				if(count1 == 5) {
					x = j-2;
					y = i-2;
					winner = 1;
					break outer;
				}
				if(count2 == 5) {
					x = j-2;
					y = i-2;
					winner = 2;
					break outer;
				}
			}
		}
		
		// 다른 대각선 탐색
		outer :for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				int count1 = 0;
				int count2 = 0;
				for(int k=-2;k<=2;k++) {
					int nr = i+k;
					int nc = j-k;
					if(nr>=0 && nr<20 && nc>=0 && nc<20) {
						if(arr[nr][nc] == 1) {
							count1++;
						}
						else if(arr[nr][nc] == 2) {
							count2++;
						}
					}
				}
				if(count1 == 5) {
					x = j+2;
					y = i-2;
					winner = 1;
					break outer;
				}
				if(count2 == 5) {
					x = j+2;
					y = i-2;
					winner = 2;
					break outer;
				}
			}
		}
		System.out.println(winner);
		System.out.printf("%d %d", y, x);
		
		
		
	}
}

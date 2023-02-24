package boj;

import java.util.Arrays;
import java.util.Scanner;

public class jungol_1037_오류교정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 배열값 확인하는 부분
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		int xcheck = 0;
		int ycheck = 0;
		int rememberx = 0; 
		int remembery = 0;
		int notxcount = 0;
		int notycount = 0;
		
		for(int i=0;i<N;i++) {
			int xcount = 0;
			int ycount = 0;
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) {
					xcount+=1;
				}
				if(arr[j][i] == 1) {
					ycount+=1;
				}
			}
			if(xcount%2 == 0) {
				xcheck += 1;
			}
			else {
				rememberx = i;
				notxcount += 1;
			}
			if(ycount%2 == 0) {
				ycheck += 1;
			}
			else {
				remembery = i;
				notycount += 1;
			}
		}
		if(xcheck == N && ycheck == N) {
			System.out.println("OK");
		}
		else if(notxcount > 1 | notycount > 1) {
			System.out.println("Corrupt");
		}
		else if(notxcount == 1 && notycount == 1) {
			System.out.printf("Change bit (%d,%d)", rememberx+1, remembery+1);
		}
	}
}

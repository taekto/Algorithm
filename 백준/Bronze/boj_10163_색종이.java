package boj;

import java.util.Scanner;

public class boj_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 색종이의 장수 N
		int N = sc.nextInt();
		// 색종이 도화지
		int[][] arr = new int[1001][1001];
		
		for(int i=1;i<=N;i++) {
			// 시작점 x, y
			int X = sc.nextInt();
			int Y = sc.nextInt();
			// 너비 W
			int W = sc.nextInt();
			// 높이 H
			int H = sc.nextInt();
			for(int j=Y;j<Y+H;j++) {
				for(int k=X;k<X+W;k++) {
					if(k >= 0 && j >= 0 && k <= 1000 && j <= 1000) {
						arr[j][k] = i;
					}
				}
			}			
		}
		for(int i=1;i<=N;i++) {
			int sum = 0;
			for(int j=0;j<1001;j++) {
				for(int k=0;k<1001;k++) {
					if(arr[j][k] == i) {
						sum +=1;
					}
				}
			}
			System.out.println(sum);
		}
	}
}

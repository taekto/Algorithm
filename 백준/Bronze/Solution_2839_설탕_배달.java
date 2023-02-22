package boj;

import java.util.Scanner;

public class Solution_2839_설탕_배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 설탕 N키로그램
		int N = sc.nextInt();
		
		int max = N/3;
		int a5 = 0;
		int a3 = 0;
		
		for(int i=0;i<=max;i++) {
			for(int j=0;j<=max;j++) {
				if(i*5 + j*3 == N && i>=a5) {
					a5 = i;
					a3 = j;
				}
			}
		}
		
		if(a5 == 0 && a3 == 0) {
			System.out.println(-1);
		} else {
			System.out.println(a5+a3);
		}
		
		
	}
}

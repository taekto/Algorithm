package boj;

import java.util.Scanner;

public class boj_2851_슈퍼_마리오 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int sum2 = 0;
		for(int i=1;i<=10;i++) {
			int a = sc.nextInt();
			sum2 = sum2 + a;

			if(Math.abs(sum+a-100) < Math.abs(sum-100)) {
				sum = sum+a;
			} else {
				continue;
			}
			if(Math.abs(sum+a-100) == Math.abs(sum-100)) {
				sum = sum+a;
			}
		}
		System.out.println(sum);
		
		
	}

}

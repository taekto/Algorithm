package boj;

import java.util.Scanner;

public class boj_2851_슈퍼_마리오2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		int sum2 = 0;
		
		for(int i=0;i<10;i++) {
			sum2 = sum2 + arr[i];

			if(Math.abs(sum+arr[i]-100) <= Math.abs(sum-100)) {
				sum = sum+arr[i];
			}
			if(sum2 >= 100) {
				break;
			}
			
		}
		System.out.println(sum);

		
		
	}

}

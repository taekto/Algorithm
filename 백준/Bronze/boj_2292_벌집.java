package boj;

import java.util.Scanner;

public class boj_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int count = 1;
		
		int data = 1;
		
		while(data < N) {
			data += count*6;
			count +=1;
			
		}
		System.out.println(count);
		
		
	}

}

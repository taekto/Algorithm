package boj;

import java.util.Scanner;

public class boj_2810_컵홀더 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		str = str.replace("LL", "A");
		
		int count = 0;
		
		if(str.contains("A")) {
			count = str.length() + 1;
		}
		else {
			count = N;
		}
		System.out.println(count);
		
	}

}

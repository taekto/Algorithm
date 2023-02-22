package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_14696_딱지놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 라운드 수 N
		int N = sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			// 어린이 A의 그림의 수
			int a = sc.nextInt();
			int[] Aarr = new int[5];
			// 1, 2, 3, 4에 각 갯수 더하기
			for(int j=0;j<a;j++) {
				Aarr[sc.nextInt()]++;
			}
			
			int b = sc.nextInt();
			int[] Barr = new int[5];
			// 1, 2, 3, 4에 각 갯수 더하기
			for(int j=0;j<b;j++) {
				Barr[sc.nextInt()]++;
			}
			
			if(Aarr[4] > Barr[4]) {
				System.out.println("A");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] > Barr[3]) {
				System.out.println("A");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] == Barr[3] && Aarr[2] > Barr[2]) {
				System.out.println("A");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] == Barr[3] && Aarr[2] == Barr[2] && Aarr[1] > Barr[1]) {
				System.out.println("A");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] == Barr[3] && Aarr[2] == Barr[2] && Aarr[1] == Barr[1]) {
				System.out.println("D");
				continue;
			}
			if(Aarr[4] < Barr[4]) {
				System.out.println("B");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] < Barr[3]) {
				System.out.println("B");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] == Barr[3] && Aarr[2] < Barr[2]) {
				System.out.println("B");
				continue;
			}
			if(Aarr[4] == Barr[4] && Aarr[3] == Barr[3] && Aarr[2] == Barr[2] && Aarr[1] < Barr[1]) {
				System.out.println("B");
				continue;
			}
			
			
			
			
		}
		
	}
}

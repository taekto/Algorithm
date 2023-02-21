package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_3985_롤_케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 롤케이크 길이 L
		int L = sc.nextInt();
		// 방청객수 N
		int N = sc.nextInt();
		
		// 롤케익 배열
		int[] arr = new int[L+1];
		for(int i=1;i<=arr.length-1;i++) {
			arr[i] = 1;
		}
		// 케익 받은거 저장할 배열
		int[] cake = new int[N+1];
		
		// 기대 값 저장
		int[] cakepredict = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			// P 부터 K 까지
			int P = sc.nextInt();
			int K = sc.nextInt();
			cakepredict[i] = K-P+1;
			int count = 0;
			for(int j=P;j<=K;j++) {
				if(arr[j] == 1) {
					count +=1;
					arr[j] = 0;
				}
			}
			cake[i] = count;
		}
		int cakemax = 0;
		int cakepredictmax = 0;
		for(int i=1;i<=cake.length-1;i++) {
			if(cake[i] > cakemax) {
				cakemax = cake[i];
			}
			if(cakepredict[i] > cakepredictmax) {
				cakepredictmax = cakepredict[i];
			}
		}
		for(int i=1;i<=N;i++) {
			if(cakepredictmax == cakepredict[i]) {
				System.out.println(i);
				break;
			}
		}
		for(int i=1;i<=N;i++) {
			if(cakemax == cake[i]) {
				System.out.println(i);
				break;
			}
		}

		
		
		
		
	}
}

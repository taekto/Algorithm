package D2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class swea_1859_taekto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			// 배열의 크기 N 입력받기
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int j=0;j<N;j++) {
				arr[j] = sc.nextInt();
			}
			
			int max = 0;
			long sum = 0;
			for(int j=N-1;j>=0;j--) {
				
				if(max < arr[j]) {
					max = arr[j];
				}
				
				if(arr[j] < max) {
					sum = sum - arr[j] + max;
				}
				
				
				
				
			}
			
			System.out.println("#"+i+" "+sum);
			
			
			
			
			
			
		}
		
		
	}

}
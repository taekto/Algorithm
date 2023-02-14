package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten_박기택 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 T
		int T = 10;
		
		for(int i=1;i<=T;i++) {
			// 평탄화 작업 횟수 N 입력받기
			int N = sc.nextInt();
			int[] arr = new int[100];
			// arr에 값 집어넣기
			for(int j=0;j<arr.length;j++) {
				arr[j] = sc.nextInt();
			}
			
			for(int j=0;j<arr.length-1;j++) {
				int minidx = j;
				for(int k=j+1;k<arr.length;k++) {
					if(arr[k] < arr[minidx]) {
						minidx = k;
					}
					
				}
				int temp = arr[j];
				arr[j] = arr[minidx];
				arr[minidx] = temp;
				
			}
			
			
			int count = 0;
			while( N-count > 0) {
				// 가로 입력받을 arr 생성



					
				arr[0] = arr[0] + 1;
				arr[99] = arr[99] -1;
				count++;
				
				for(int j=0;j<arr.length-1;j++) {
					int minidx = j;
					for(int k=j+1;k<arr.length;k++) {
						if(arr[k] < arr[minidx]) {
							minidx = k;
						}
						
					}
					int temp = arr[j];
					arr[j] = arr[minidx];
					arr[minidx] = temp;
					
				}

				
			}
			System.out.println("#"+i+" "+(arr[99]-arr[0]));
//			System.out.println(Arrays.toString(arr));
			
			
		}
		
	}

}

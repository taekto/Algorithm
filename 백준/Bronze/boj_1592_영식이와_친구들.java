package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1592_영식이와_친구들 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N 자리의 갯수, M 한사람이 M번 공받으면 끝남, L번째
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N+1];
		int index = 1;
		int count = 0;
		
		outer :while(true) {
			if(M == 1) {
				count = 1;
				break outer;
			}

			arr[index] += 1;
			
			
			if(arr[index] % 2 == 1) {
				index += L;
				index = index%N;
				count +=1;
			} 
			else if(arr[index] % 2 == 0){
				index += N-L;
				index = index%N;
				count +=1;
			}
			for(int i=0;i<arr.length;i++) {
				if(arr[i] == M) {
					break outer;
				}
			}

		}
		System.out.println(count-1);
		
		
		
		
	}

}

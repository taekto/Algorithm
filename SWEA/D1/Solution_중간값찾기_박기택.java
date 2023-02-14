package D1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_중간값찾기_박기택 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<N-1;i++) {
			int minidx = i;
			for(int j=i+1;j<N;j++) {
				if(arr[j] < arr[minidx]) {
					minidx = j;
				}
				
			}
			int temp = arr[minidx];
			arr[minidx] = arr[i];
			arr[i] = temp;
		}
		System.out.println(arr[N/2]);
		
		
		
	}

}

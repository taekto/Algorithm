package DoitJava;

import java.util.Arrays;
import java.util.Scanner;

public class boj11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] sumarr = new int[n+1];
		
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum += arr[i];
			sumarr[i] = sum;
		}
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(sumarr[b]-sumarr[a-1]);
			
		}
		
	}

}

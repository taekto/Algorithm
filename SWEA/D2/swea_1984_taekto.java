package D2;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1984_taekto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			
			int[] arr = new int[10];
			for(int j=0;j<10;j++) {
				arr[j] = sc.nextInt();
			}
			
			
			for(int j=0;j<9;j++) {
				for(int k=0;k<9-j;k++) {
					if(arr[k] > arr[k+1]) {
						
						int num = arr[k];
						arr[k] = arr[k+1];
						arr[k+1] = num;
					}
				
					
					
				}
//				System.out.println(Arrays.toString(arr));
				
			}
//			System.out.println(Arrays.toString(arr));
			double sum = 0;
			for(int j=1;j<=8;j++) {
				sum += arr[j];
			}
			
			System.out.println("#"+i+" "+(int) Math.round(sum/8));
			
			
			
		}
		
		
		
	}

}
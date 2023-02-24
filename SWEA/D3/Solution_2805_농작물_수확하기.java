package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2805_농작물_수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for(int j=0;j<N;j++) {
				String str = sc.next();
				for(int k=0;k<N;k++) {
					arr[j][k] = str.charAt(k)-'0';
				}
			}
			// 포인터 left, right 정의
			int left = N/2;
			int right = N/2;
			
			int profit = 0;
			for(int j=0;j<N;j++) {
				if(j<N/2) {
					for(int k=left;k<=right;k++) {
						profit += arr[j][k];
					}
					left--;
					right++;
				}
				else {
					for(int k=left;k<=right;k++) {
						profit += arr[j][k];
					}
					left++;
					right--;
				}
			}
			System.out.println("#"+i+" "+profit);
		}
		
		
	}
}

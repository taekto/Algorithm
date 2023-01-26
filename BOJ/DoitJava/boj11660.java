package DoitJava;

import java.util.Arrays;
import java.util.Scanner;

public class boj11660 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] newarr = new int[N+1][N+1];
//		newarr[1][1] = arr[1][1];
		
//		for(int i=1;i<=N;i++) {
//			newarr[1][i] = newarr[1][i-1] + arr[1][i];
//			newarr[i][1] = newarr[i-1][1] + arr[i][1];
//		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				newarr[i][j] = newarr[i-1][j] + newarr[i][j-1] + arr[i][j] - newarr[i-1][j-1];
			}
		}
		
		
		for(int i=1;i<=M;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(newarr[x2][y2]-newarr[x1-1][y2]-newarr[x2][y1-1]+newarr[x1-1][y1-1]);
			
		}
		
//		System.out.println(Arrays.toString(newarr[1]));
//		System.out.println(Arrays.toString(newarr[2]));
//		System.out.println(Arrays.toString(newarr[3]));
//		System.out.println(Arrays.toString(newarr[4]));
		
		
	}

}

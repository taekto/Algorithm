package boj;

import java.util.Scanner;

public class boj_2999_비밀_이메일 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int N = str.length();
		int r = 1;
		int c = 1;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if((i*j) == N && i>=r && i<=j) {
					r = i;
					c = j;
				}
			}
		}
		String[][] arr = new String[r][c];
		int index = 0;
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				arr[j][i] = String.valueOf(str.charAt(index++));
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(arr[i][j]);
			}
		}
		
	}
}

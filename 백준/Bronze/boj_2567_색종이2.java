package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 색종이의 수 N
		int N = sc.nextInt();
		// clear할 범위 저장할 range
		List<Integer> range = new ArrayList<>();
		// 색종이 정의
		int[][] paper = new int[101][101];
		
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 테두리들 에만 1 채우기
			for(int j=x;j<x+10;j++) {
				paper[y][j] = 1;
			}
		}
		
		
	}
}

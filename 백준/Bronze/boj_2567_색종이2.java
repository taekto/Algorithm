package boj;

import java.util.Scanner;

public class boj_2567_색종이2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 색종이 갯수 N
		int N = sc.nextInt();
		
		// 도화지 
		int[][] paper = new int[101][101];
		
		
		// 색종이 갯수 만큼 반복
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++) {
					paper[j][k] = 1;
				}
			}
		}
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0 , 0, -1, 1};
		
		int count = 0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(paper[i][j] == 1) {
					if(i == 0 | j== 0 | i == 100 | j == 0) {
						count++;
					}
					
					for(int k=0;k<4;k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						
						if(nr >= 0 && nr <101 && nc >= 0 && nc <101 && paper[nr][nc] == 0) {
							count +=1;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}

import java.util.Scanner;

public class Main {
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
		
		int sum = 0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				sum += paper[i][j];
			}
		}
		System.out.println(sum);
		
		
	}

}

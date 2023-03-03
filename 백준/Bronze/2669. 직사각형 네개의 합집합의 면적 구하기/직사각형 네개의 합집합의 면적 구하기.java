import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[101][101];
		
		for(int i=0;i<4;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			for(int j=y;j<q;j++) {
				for(int k=x;k<p;k++) {
					arr[j][k] = 1;
				}
			}
		}
		int sum = 0;
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				sum+= arr[i][j];
			}
		}
		System.out.println(sum);
	}
}

package D3;
import java.util.Scanner;

public class 회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] grid = new char[100][100];
		int answer;
		boolean check;
		
		for (int test_case = 0; test_case < 10; test_case++) {
			int tc = sc.nextInt();
			answer = 0;
			for (int i = 0; i < grid.length; i++) {
				String str = sc.next();
				for (int j = 0; j < grid.length; j++) {
					grid[i][j] = str.charAt(j);
				}
			}
			
			for (int len = 0; len <= grid.length; len++) {
				for (int i = 0; i < grid.length; i++) {
					for (int j = 0; j <= grid.length - len; j++) {
						check = true;
						for (int k = 0; k < len/2; k++) {
							if (grid[i][j+k] != grid[i][j+len-k-1]) {
								check = false;
								break;
							}
						}
						if (check && answer < len) answer = len; 
					}
				}
				
				for (int j = 0; j < grid.length; j++) {
					for (int i = 0; i <= grid.length - len; i++) {
						check = true;
						for (int k = 0; k < len/2; k++) {
							if (grid[i+k][j] != grid[i+len-k-1][j]) {
								check = false;
								break;
							}
						}
						if (check && answer < len) answer = len; 
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
}
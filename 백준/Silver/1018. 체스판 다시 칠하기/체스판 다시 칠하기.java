import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static char[][] arr;
	public static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				int countblack = 0;
				int countwhite = 0;
				for(int k=0+i;k<8+i;k++) {
					for(int m=0+j;m<8+j;m++) {
						if((k+m)%2 == 0 && arr[k][m] == 'B') countblack++;
						else if((k+m)%2 == 1 && arr[k][m] == 'W') countblack++;
						if((k+m)%2 == 0 && arr[k][m] == 'W') countwhite++;
						else if((k+m)%2 == 1 && arr[k][m] == 'B') countwhite++;
						
						
					}
				}
				result = Math.min(result, Math.min(countblack, countwhite));
			}
		}
		
		System.out.println(result);
		
		
	}
}
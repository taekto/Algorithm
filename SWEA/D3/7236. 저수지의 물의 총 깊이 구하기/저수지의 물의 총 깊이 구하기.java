import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 T
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			// 저수지 구획의 크기 N 입력받기
			int N = sc.nextInt();
			String[][] arr = new String[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k] = sc.next();
				}
			}
			// 789456123순
			int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dc = {-1, 0, 1, -1 , 1, -1, 0 ,1};
			int count = 0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					int gcount = 0;
					int wcount = 0;
					for(int m=0;m<8;m++) {
						int nr = dr[m] + j;
						int nc = dc[m] + k;
						if(nr>= 0 && nr<N && nc>=0 && nc<N) {
							if(arr[nr][nc].equals("W")) {
								wcount +=1;
							}
							else if(arr[nr][nc].equals("G")) {
								gcount +=1;
							}
						}
					}
					if(gcount == 8 && gcount > count) {
						count = 1;
					}
					else if(wcount > count) {
						count = wcount;
					}
				}
			}
			System.out.println("#"+i+" "+count);
		}
	}
}

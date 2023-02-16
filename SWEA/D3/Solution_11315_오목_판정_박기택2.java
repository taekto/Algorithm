package D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_11315_오목_판정_박기택2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int i=1;i<=T;i++) {
			
			int N =sc.nextInt();
			
			String[][] arr = new String[N][N];
			
			for(int j=0;j<N;j++) {
				String str = sc.next();
				
				for(int k=0;k<N;k++) {
					arr[j][k] = String.valueOf(str.charAt(k));
				}
			}
			
			int[] dc = {-2, -1, 0, 1, 2};
			int resultcount = 0;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					int count = 0;
					for(int m=0;m<dc.length;m++) {
						if(k+dc[m] >= 0 && k+dc[m] <N) {
							if(arr[j][k+dc[m]].equals("o")) {
								count +=1;
							}
						}
					}
					if(count == 5) {
						resultcount +=1;
					}
				}
			}
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					int count = 0;
					for(int m=0;m<dc.length;m++) {
						if(k+dc[m] >= 0 && k+dc[m] <N) {
							if(arr[k+dc[m]][j].equals("o")) {
								count +=1;
							}
						}
					}
					if(count == 5) {
						resultcount +=1;
					}
				}
			}
			
			int[] cross1 = {-2, -1, 0 , 1, 2};
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					int count = 0;
					for(int m=0;m<cross1.length;m++) {
						if(k+cross1[m] >= 0 && k+cross1[m] <N && j+cross1[m] >= 0 && j+cross1[m] <N) {
							if(arr[j+cross1[m]][k+cross1[m]].equals("o")) {
								count +=1;
							}
						}
					}
					if(count == 5) {
						resultcount +=1;
					}
				}
			}
			int[] cross2 = {2, 1, 0 , -1 , -2};
			int[] cross3 = {-2, -1, 0 , 1, 2};
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					int count = 0;
					for(int m=0;m<cross2.length;m++) {
						if(k+cross2[m] >= 0 && k+cross2[m] <N && j+cross3[m] >= 0 && j+cross3[m] <N) {
							if(arr[j+cross3[m]][k+cross2[m]].equals("o")) {
								count +=1;
							}
						}
					}
					if(count == 5) {
						resultcount +=1;
					}
				}
			}
			
			if(resultcount >= 1) {
				System.out.println("#"+i+" "+"YES");
			}
			else {
				System.out.println("#"+i+" "+"NO");
			}
			
			
		}
		
		
		
		
	}

}

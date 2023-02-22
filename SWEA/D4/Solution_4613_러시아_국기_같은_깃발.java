package D4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_4613_러시아_국기_같은_깃발 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 테케 T
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] arr = new char[N][M];
			
			for(int j=0;j<N;j++) {
				String str = sc.next();
				for(int k=0;k<M;k++) {
					arr[j][k] = str.charAt(k);
				}
			}
			// 첫째 줄은 무조껀 흰색
			for(int j=0;j<M;j++) {
				if(arr[0][j] != 'W') {
					arr[0][j] = '1';
				}
			}
			// 마지막 줄은 무조껀 빨간색
			for(int j=0;j<M;j++) {
				if(arr[N-1][j] != 'R') {
					arr[N-1][j] = '1';
				}
			}
			List<Integer> result = new ArrayList<>();
			
			for(int j=0;j<=N-2;j++) {
				for(int k=0;k<=N-2;k++) {
					for(int m=0;m<=N-2;m++) {
						if( k > 0 && j+k+m == N-2) {
							// 갯수 셀 count 정의
							int count = 0;
							// 흰색 
							for(int n=1;n<j+1;n++) {
								count += white(arr[n]);
							}
							// 파란색
							for(int n=j+1;n<j+k+1;n++) {
								count += blue(arr[n]);
							}
							// 빨간색
							for(int n=j+k+1;n<j+k+m+1;n++) {
								count += red(arr[n]);
							}
							result.add(count);
							
						}
					}
				}
			}
			result.sort(null);
			int realresult = 0;
			realresult = result.get(0);
			
			for(int j=0;j<M;j++) {
				if(arr[0][j] == '1') {
					realresult +=1;
				}
			}
			// 마지막 줄은 무조껀 빨간색
			for(int j=0;j<M;j++) {
				if(arr[N-1][j] == '1') {
					realresult +=1;
				}
			}
			
			System.out.println("#"+i+" "+realresult);
//			System.out.println(Arrays.toString(arr[0]));
//			System.out.println(Arrays.toString(arr[1]));
//			System.out.println(Arrays.toString(arr[2]));
//			System.out.println(Arrays.toString(arr[3]));
			
			
		}
	}
	// 흰색으로 만들려면
	public static int white(char arr[]) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != 'W') {
				count +=1;
			}
		}
		return count;
		
	}
	public static int blue(char arr[]) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != 'B') {
				count +=1;
			}
		}
		return count;
		
	}
	public static int red(char arr[]) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != 'R') {
				count +=1;
			}
		}
		return count;
		
	}
}

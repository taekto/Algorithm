package D2;

import java.util.Scanner;

public class Solution_1979_어디에_단어가_들어갈_수_있을까_박기택_fail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] arr = new int[N][N];
			// 전체 세기
			int result = 0;
			
			// 배열에 1과 0 넣기
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			// 가로 앞 부분 확인
			for(int j=0;j<N;j++) {
				// 1값 셀 count 정의
				int count = 0;
				for(int k=0;k<K;k++) {
					if(arr[j][k] == 1) {
						count +=1;
					}
					
				}
				if(count == K && arr[j][K] == 0) {
					result +=1;
				}
				
			}
			
			// 가로 뒷 부분 확인
			for(int j=0;j<N;j++) {
				// 1값 셀 count 정의
				int count = 0;
				for(int k=N-1;k>=N-K;k--) {
					if(arr[j][k] == 1) {
						count +=1;
					}
					
				}
				if(count == K && arr[j][N-K-1] == 0) {
					result +=1;
				}
				
			}
			
			// 세로 윗 부분 확인
			for(int j=0;j<N;j++) {
				// 1값 셀 count 정의
				int count = 0;
				for(int k=0;k<K;k++) {
					if(arr[k][j] == 1) {
						count +=1;
					}
					
				}
				if(count == K && arr[K][j] == 0) {
					result +=1;
				}
				
			}
			
			// 세로 아랫 부분 확인
			for(int j=0;j<N;j++) {
				// 1값 셀 count 정의
				int count = 0;
				for(int k=N-1;k>=N-K;k--) {
					if(arr[k][j] == 1) {
						count +=1;
					}
					
				}
				if(count == K && arr[N-K-1][j] == 0) {
					result +=1;
				}
				
			}
			// 가로 중간부분 세기
			
			
			for(int j=0;j<N;j++) {
				for(int a=0;a<N-K;a++) {
					int count = 0;
					// 왼쪽 가장자리가 0인지 판단할 변수
					int leftcheck = 0;
					// 오른쪽 가장자리가 0인지 판단할 변수
					int rightcheck = 0;
					int pointer = 1;
					// 포인터 
					for(int k=pointer;k<pointer+K;k++) {
						if(pointer+K-1 == N-1) {
							break;
						}
						if(k == pointer) {
							if(arr[j][k-1] == 0) {
								leftcheck = 1;
							}
						}
						if(k == pointer+K-1) {
							if(arr[j][k+1] == 0) {
								rightcheck = 1;
							}
						}
						if(arr[j][k] == 1) {
							count += 1;
						}
						
					}
					pointer++;
					if(rightcheck == 1 && leftcheck == 1 && count == K) {
						result += 1;
					}
				}
		}
			
			// 세로 중간부분 세기

			System.out.println(result);
			
			
		
	}

}
}

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			//각 테스트 케이스의 첫 번째 줄에는 세 자연수 N, M, K(1 ≤ N, M, K ≤ 100)가 공백으로 구분되어 주어진다.
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			boolean isok = true;
			// 사람몇명인지 저장
			int[] arr = new int[11112];
			// 두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며, 각 정수는 각 사람이 언제 도착하는지를 초 단위로 나타낸다. 각 수는 0이상 11,111이하이다.
			for(int i=0;i<N;i++) {
				// 몇초에 오는지 사람이
				int people = sc.nextInt();
				arr[people]++;
			}
			
			int bread = 0;
			for(int i=0;i<11112;i++) {
				if(i != 0 && i%M == 0) bread += K;
				bread -= arr[i];
				
				if(bread < 0) {
					isok = false;
				}
			}
			if(isok) {
				System.out.println("#"+tc+" "+"Possible");
			}
			else {
				System.out.println("#"+tc+" "+"Impossible");
			}
		}
	}
}

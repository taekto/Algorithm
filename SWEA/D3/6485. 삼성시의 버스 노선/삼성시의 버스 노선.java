import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			// 버스 범위 저장할 배열 생성
			int[] arr = new int[5001];
			
			// N번 반복
			int N = sc.nextInt();
			
			for(int i=0;i<N;i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				for(int j=A;j<=B;j++) {
					arr[j]++;
				}
			}
			// P번 반복
			int P = sc.nextInt();
			System.out.print("#"+tc+" ");
			for(int i=1;i<=P;i++) {
				int C = sc.nextInt();
				System.out.print(arr[C]+" ");
			}
			System.out.println();
		}
	}
}

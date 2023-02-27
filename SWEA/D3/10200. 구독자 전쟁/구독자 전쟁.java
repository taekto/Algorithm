import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			// N, A, B
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int min = 0;
			int max = 0;
			
			max = Math.min(A, B);
			// 각각 의 값이 N보다 작고 더해도 N보다 작을 때
			if(A < N && B < N && A+B < N) {
				min = 0;
			}
			// 각각의 값이 N보다 작지만 더하면 N보다 클때
			else if(A < N && B < N && A+B >= N) {
				min = A+B-N;
			}
			else if(A == N && B < N) {
				min = A+B-N;
			}
			else if(B == N && A < N) {
				min = A+B-N;
			}
			else if(A == N && B == N) {
				min = N;
			}
			
			System.out.println("#"+i+" "+max+" "+min);
		}
	}
}

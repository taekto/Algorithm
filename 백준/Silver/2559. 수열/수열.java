import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전체 날짜의 수 N
		// 합을 구하기 위한 연속적인 날짜 수
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int result = -111111111;
		
		for(int i=0;i<N-K+1;i++) {
			int sum = 0;
			for(int j=i;j<i+K;j++) {
				sum += arr[j];
			}
			if(result < sum) {
				result = sum;
			}
		}
		System.out.println(result);
	}
}

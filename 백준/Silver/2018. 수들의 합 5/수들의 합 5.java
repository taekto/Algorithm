import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int start = 1;
		int end = 1;
		
		int count = 1;
		while(start != N) {
			if(end > N) break;
			
			int sum = 0;
			for(int i=start;i<=end;i++) {
				sum += i;
			}
			if(sum == N) {
				count++;
				start++;
				end++;
			}
			else if(sum > N) {
				start++;
			}
			else if(sum < N) {
				end++;
			}
		}
		System.out.println(count);
		
		
		
	}
}
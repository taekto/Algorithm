import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		for(int i=2;i<=N;i++) {
			for(int j=i;j<=N-i;j++) {
				if(i != j && i*j <= N) {
					count +=1;
				}
				if(i == j && i*j <= N) {
					count +=1;
				}
			}
		}
		count += N;
		System.out.println(count);
	}

}

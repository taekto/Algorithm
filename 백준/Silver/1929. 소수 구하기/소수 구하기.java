import java.util.Scanner;

public class Main {
	public static boolean prime[] = new boolean[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2;i*i<=1000000;i++) {
			if(!prime[i]) {
				for(int j=i*i;j<=1000000;j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i=start;i<=end;i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
		
		
	}
}
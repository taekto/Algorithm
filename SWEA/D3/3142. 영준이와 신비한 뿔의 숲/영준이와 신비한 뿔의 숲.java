import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			// N 이 뿔, M 이 동물숫자
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int unicorn = 0;
			int twinhorn = 0;
			outer :for(int i=0;i<=M;i++) {
				for(int j=0;j<=M;j++) {
					if((i+j*2) == N && i+j == M) {
						unicorn = i;
						twinhorn = j;
						break outer;
					}
				}
			}
			System.out.println("#"+tc+" "+unicorn+" "+twinhorn);
			
		}
		
	}
}
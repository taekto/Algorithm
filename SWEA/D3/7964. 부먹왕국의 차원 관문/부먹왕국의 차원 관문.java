import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 T
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			// 필요한 관문수
			int count = 0;
			// 0을 셀 zerocount
			int zerocount = 0;
			for(int j=0;j<N;j++) {
				String str = sc.next();
				if(zerocount == D) {
					count +=1;
					zerocount = 0;
				}
				if(str.equals("0")) {
					zerocount +=1;
				}
				if(str.equals("1")) {
					zerocount = 0;
				}
			}
			if(zerocount > 0) {
				count +=1;
			}
			System.out.println("#"+i+" "+count);
			
			
		}
	}
}

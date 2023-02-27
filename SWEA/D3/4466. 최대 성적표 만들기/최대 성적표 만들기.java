import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<N;j++) {
				list.add(sc.nextInt());
			}
			list.sort(null);
			int sum = 0;
			int index = 0;
			for(int j=list.size()-1;j>=0;j--) {
				if(index == K) {
					break;
				}
				sum += list.get(j);
				index++;
			}
			System.out.println("#"+i+" "+sum);
		}
		
	}
}

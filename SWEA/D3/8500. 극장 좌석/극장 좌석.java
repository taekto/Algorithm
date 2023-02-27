import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 하나의 정수 N
			int N = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<N;j++) {
				list.add(sc.nextInt());
			}
			list.sort(null);
//			System.out.println(list);
			int sum = 0;
			sum += list.get(list.size()-1)*2+1;
			list.remove(list.size()-1);
			while(!list.isEmpty()) {
				sum += list.get(list.size()-1)+1;
				list.remove(list.size()-1);
			}
			System.out.println("#"+tc+" "+sum);
			
			
		}
		
	}
}
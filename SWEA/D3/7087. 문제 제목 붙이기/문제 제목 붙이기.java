import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
//		char[] ch = {'A', 'C', 'D', 'A', 'B', 'C'};
//		
//		List<Character> list = new ArrayList<>();
//		list.add('F');
//		list.add('B');
//		list.add('E');
//		list.add('C');
//		list.add('B');
//		list.add('A');
//		System.out.println(list);
//		list.sort(null);
//		System.out.println(list);
//		
//		HashSet<Character> hs = new HashSet<>();
//		System.out.println(list.contains('G'));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			List<Character> list = new ArrayList<>();
			for(int j=0;j<N;j++) {
				String str = sc.next();
				if(!list.contains(str.charAt(0))) {
					list.add(str.charAt(0));
				}
			}
			list.sort(null);
			
			int index = 0;
			int count = 0;
			
			for(int j=65;j<65+list.size();j++) {
				if((int) list.get(index++) == j ) {
					count+=1;
				}
			}
			System.out.println("#"+i+" "+count);
			
		}
		
	}
}

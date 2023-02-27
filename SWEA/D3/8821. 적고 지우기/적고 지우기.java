import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String str = sc.next();
			List<Integer> list = new ArrayList<>();
			
			for(int j=0;j<str.length();j++) {
				if(!list.contains(str.charAt(j)-'0')) {
					list.add(str.charAt(j)-'0');
				}
				else if(!list.isEmpty() && list.contains(str.charAt(j)-'0')) {
					list.remove(Integer.valueOf(str.charAt(j)-'0'));
				}
//				System.out.println(list);
			}
			System.out.println("#"+i+" "+list.size());
			
			
			
		}
		
	}
}

package D3;

import java.util.HashSet;
import java.util.Scanner;

public class Solution_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			String str = sc.next();
			HashSet<String> check = new HashSet<>();
			int index = 0;
			int[] arr = {0, 13, 13, 13, 13};
			for(int j=1;j<=str.length()/3;j++) {
				String a = str.substring(0+index, 3+index);
				check.add(a);
				if(a.substring(0,1).equals("S")) {
					arr[1] -= 1;
				}
				else if(a.substring(0,1).equals("D")) {
					arr[2] -= 1;
				}
				else if(a.substring(0,1).equals("H")) {
					arr[3] -= 1;
				}
				else if(a.substring(0,1).equals("C")) {
					arr[4] -= 1;
				}
				index +=3;
			}
			
			
			if(str.length()/3 != check.size()) {
				System.out.println("#"+i+" ERROR");
			}
			else {
				System.out.print("#"+i+" ");
				for(int j=1;j<arr.length;j++) {
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
			
			
			
		}
		
	}
}

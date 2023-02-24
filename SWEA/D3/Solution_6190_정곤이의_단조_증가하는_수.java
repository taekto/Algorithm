package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_6190_정곤이의_단조_증가하는_수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테케 T 받기
		int T = sc.nextInt();
		
		for(int i=1;i<=T;i++) {
			// 숫자 N 받기
			int N = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<N;j++) {
				list.add(sc.nextInt());
			}
			list.sort(null);
			// 가장큰값 저장할 list 생성
			List<Integer> maxlist = new ArrayList<>();
			
			for(int j=0;j<list.size()-1;j++) {
				for(int k=j+1;k<list.size();k++) {
					int a = list.get(j)*list.get(k);
					String str = String.valueOf(a);
					int count = 0;
					for(int m=0;m<str.length()-1;m++) {
						if(Integer.parseInt(String.valueOf(str.charAt(m)))+0 <= Integer.parseInt(String.valueOf(str.charAt(m+1)))+0) {
							count++;
						}
					}
					if(count == str.length()-1) {
						maxlist.add(a);
					}
				}
			}
			maxlist.sort(null);
			if(maxlist.isEmpty()) {
				System.out.println("#"+i+" "+(-1));
			} else {
				System.out.println("#"+i+" "+maxlist.get(maxlist.size()-1));
			}
		}
	}
}

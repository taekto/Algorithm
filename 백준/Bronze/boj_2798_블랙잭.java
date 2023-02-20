package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2798_블랙잭 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		int result = 0;
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}

		
		for(int a=0;a<N;a++) {
			for(int b=0;b<N;b++) {
				if(b != a) {
					for(int c=0;c<N;c++) {
						if(c != a && c != b) {
							int sum = list.get(a) + list.get(b) + list.get(c);
							if(sum <= M && sum > result) {
								result = sum;
							}
						}
					}
 				}
			}
		}
		
		System.out.println(result);
	}

}

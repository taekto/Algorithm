package day0302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jungol_1205_joker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 카드의 갯수 N
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int joker = 0;
		
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			if(a == 0) {
				joker++;
			}
			else {
				list.add(a);
			}
		}
		list.sort(null);
//		System.out.println(list);
//		System.out.println(joker);
		// 몇번 연속된 숫자인지? 
		int result = 0;
		for(int i=0;i<list.size();i++) {
			int count = 1;
			int instancejoker = joker;
			int usejoker = 0;
			for(int j=i;j<list.size()-1;j++) {
				if(list.get(j+1) - list.get(j) >= 2 && list.get(j+1)-list.get(j)-1 > instancejoker) {
					break;
				}
				if(list.get(j+1) - list.get(j) == 1) {
					count++;
				}
				else if(list.get(j+1) - list.get(j) >= 2 && list.get(j+1)-list.get(j)-1 <= instancejoker) {
					count += list.get(j+1) - list.get(j);
					instancejoker = instancejoker -list.get(j+1) + list.get(j)+1;
				}
			}
//			System.out.printf("%d번째 i에서 count값 %d joker값 %d\n",i,count,instancejoker);
			if(instancejoker >= 1) {
				count += instancejoker;
			}
			if(count > result) {
				result = count;
			}
		}
		if(list.size() == 0) {
			System.out.println(joker);
		}
		else {
			System.out.println(result);

		}
	}
}

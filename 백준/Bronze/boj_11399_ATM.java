package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		list.sort(null);
		System.out.println(list);
		
		List<Integer> newlist = new ArrayList<>();
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			sum += list.get(i);
			newlist.add(sum);
		}
		
		int result = 0;
		for(int i=0;i<N;i++) {
			result += newlist.get(i);
		}
		System.out.println(result);
		
		
	}
}

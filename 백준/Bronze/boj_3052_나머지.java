package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class boj_3052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0;i<10;i++) {
			int a = sc.nextInt();
			hs.add(a%42);
		}
		System.out.println(hs.size());
	}

}

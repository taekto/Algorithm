import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			if(!map.containsKey(a)) {
				map.put(a, 1);
			}
			else {
				map.put(a, map.get(a)+1);
			}
		}
		StringBuilder sb = new StringBuilder();
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			if(!map.containsKey(a)) {
				sb.append(0+" ");
			}
			else {
				sb.append(map.get(a)+" ");
			}
		}
		System.out.println(sb);
		
	}
}
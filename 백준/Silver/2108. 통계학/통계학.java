import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			list.add(a);
			if(!map.containsKey(a)) {
				map.put(a, 1);
			}
			else {
				map.put(a, map.get(a)+1);
			}
		}
		
		Double avg = (double) 0;
		int mid = 0;
		int many = 0;
		int range = 0;
		
		Collections.sort(list);
		int max = 0;
		
		for(int i=0;i<N;i++) {
			avg += list.get(i);
			max = (int) Math.max(max, map.get(list.get(i)));
		}
		
		List<Integer> resultlist = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			if(map.get(list.get(i)).equals(max)) {
				if(!resultlist.contains(list.get(i))) {
					resultlist.add(list.get(i));
				}
			}
		}
		resultlist.sort(null);
		
		System.out.println(Math.round(avg/N));
		System.out.println(list.get(N/2));
		if(resultlist.size() >= 2) {
			System.out.println(resultlist.get(1));
		}
		else {
			System.out.println(resultlist.get(0));
		}
		
		System.out.println(list.get(list.size()-1)-list.get(0));
		
		
		
		
	}
}
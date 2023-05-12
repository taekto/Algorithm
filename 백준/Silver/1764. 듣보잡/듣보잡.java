import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<String, Boolean> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i=0;i<N;i++) {
			map.put(sc.next(), true);
		}
		for(int i=0;i<M;i++) {
			String str = sc.next();
			if(map.containsKey(str)) {
				list.add(str);
			}
		}
		list.sort(null);
		sb.append(list.size()+"\n");
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
		
	}
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 가지고 있는 랜선개수 K, 필요한 랜선의 개수 N
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		List<Long> list = new ArrayList<>();
		for(int i=0;i<K;i++) {
			list.add(sc.nextLong());
		}
		
		Collections.sort(list);
		Long start = 1L;
		Long end = list.get(list.size()-1);
		Long distance = (long) 0;
		
		while(true) {
			if(start > end) break;

			int count = 0;
			Long mid = (start+end)/2;

			for(int i=0;i<K;i++) {
				count += list.get(i)/mid;
			}

			if(count >= N) {
				distance = Math.max(distance, mid);
				start = mid+1;
			}
			else if(count < N) {
				end = mid-1;
			}
		}
		System.out.println(distance);
		
		
		
		
	}
}
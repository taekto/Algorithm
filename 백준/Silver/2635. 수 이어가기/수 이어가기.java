import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> resultlist = new ArrayList<>();
		int size = 0;
		
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			List<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			int index = 0;
			while(true) {
				int a = list.get(index)-list.get(index+1);
				if(a >= 0) {
					list.add(a);
					index++;
				}
				else if(a < 0){
					break;
				}
			}
			if(list.size() > size) {
				resultlist = list;
				size = list.size();
			}
		}
		System.out.println(size);
		for(int i=0;i<resultlist.size();i++) {
			System.out.print(resultlist.get(i)+" ");
		}
		
	}
}

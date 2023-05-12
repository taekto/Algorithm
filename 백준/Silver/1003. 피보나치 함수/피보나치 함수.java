import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int count0;
	static int count1;
	
	static int pibo(int start) {

		
		if(start == 0) {
			count0 +=1;
			return 0;
		}
		else if(start == 1) {
			count1 +=1;
			return 1;
		}
		else {
			return pibo(start-1) + pibo(start-2);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Integer> list0 = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list0.add(1);
		list0.add(0);
		list1.add(0);
		list1.add(1);
		int num = 2;
		while(true) {
			if(num > 40 ) break;
			list0.add(list0.get(num-2)+list0.get(num-1));
			list1.add(list1.get(num-2)+list1.get(num-1));
			num++;
		}
		
		for(int i=0;i<T;i++) {
			int a = sc.nextInt();
			System.out.println(list0.get(a)+" "+list1.get(a));
			
		}
	}
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 학생의 수
		int student = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i=1;i<=student;i++) {
			int a = sc.nextInt();
			list.add(i-a, i);
		}
//		System.out.println(list);
		for(int i=1;i<=student;i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}

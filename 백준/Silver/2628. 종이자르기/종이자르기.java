import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 가로 x, 세로 y 값 받기
		int x = sc.nextInt();
		int y = sc.nextInt();
		// 잘라야하는 점선의 갯수
		int N = sc.nextInt();
		//가로 저장
		List<Integer> listx = new ArrayList<>();
		List<Integer> listy = new ArrayList<>();
		listx.add(0);
		listy.add(0);
		listx.add(x);
		listy.add(y);
		
		for(int i=0;i<N;i++) {
			// 가로세로 판단 
			int direction = sc.nextInt();
			int number = sc.nextInt();
			if(direction == 0) listy.add(number);
			else if(direction == 1) listx.add(number);
		}
		
		listx.sort(null);
		listy.sort(null);
		
//		System.out.println(listx);
//		System.out.println(listy);
		List<Integer> newx = new ArrayList<>();
		List<Integer> newy = new ArrayList<>();
		for(int i=0;i<listx.size()-1;i++) {
			newx.add(listx.get(i+1)-listx.get(i));
		}
		for(int i=0;i<listy.size()-1;i++) {
			newy.add(listy.get(i+1)-listy.get(i));
		}
//		System.out.println(newx);
//		System.out.println(newy);
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<newx.size();i++) {
			for(int j=0;j<newy.size();j++) {
				result.add(newx.get(i)*newy.get(j));
			}
		}
		result.sort(null);
		System.out.println(result.get(result.size()-1));
		
	}
}

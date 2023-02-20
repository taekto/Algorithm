import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 참외 갯수
		int K = sc.nextInt();
		
		List<Integer> direction = new ArrayList<>();
		
		List<Integer> length = new ArrayList<>();
		
		int[] numcount = new int[5];
		
		for(int i=0;i<6;i++) {
			int dr =sc.nextInt();
			int len = sc.nextInt();
			direction.add(dr);
			length.add(len);
		}
		
		for(int i=0;i<direction.size();i++) {
			numcount[direction.get(i)]++;
		}
		
		int bigxindex = 0;
		int bigyindex = 0;
		
		// 큰 넓이 x, y 
		int bigx = 0;
		int bigy = 0;
		
		for(int i=0;i<numcount.length;i++) {
			for(int j=0;j<numcount.length;j++) {
				if( i!= j && numcount[i] == 1 && numcount[j] == 1) {
					bigxindex = i;
					bigyindex = j;
				}
			}
		}
//		System.out.println(bigxindex);
//		System.out.println(bigyindex);
		for(int i=0;i<direction.size();i++) {
			if(direction.get(i) == bigxindex) {
				bigx = length.get(i);
			}
			if(direction.get(i) == bigyindex) {
				bigy = length.get(i);
			}
		}
		
		
//		System.out.println(direction);
//		System.out.println(length);
		
		int area = bigx*bigy;
//		System.out.println(area);
		
		int smallxindex = 0;
		int smallyindex = 0;
		// 작은거 찾기
		for(int i=0;i<=5;i++) {
			if(i == 0) {
				if((direction.get(5) == 3 && direction.get(i+1) == 3) || (direction.get(5) == 4 && direction.get(i+1) == 4)) {
					smallxindex = i;
				}
				if((direction.get(5) == 1 && direction.get(5) == 1) || (direction.get(5) == 2 && direction.get(i+1) == 2)) {
					smallyindex = i;
				}
			}
			else if(i == 5) {
				if((direction.get(i-1) == 3 && direction.get(0) == 3) || (direction.get(i-1) == 4 && direction.get(0) == 4)) {
					smallxindex = i;
				}
				if((direction.get(i-1) == 1 && direction.get(0) == 1) || (direction.get(i-1) == 2 && direction.get(0) == 2)) {
					smallyindex = i;
				}
				
			} else {
				if((direction.get(i-1) == 3 && direction.get(i+1) == 3) || (direction.get(i-1) == 4 && direction.get(i+1) == 4)) {
					smallxindex = i;
				}
				if((direction.get(i-1) == 1 && direction.get(i+1) == 1) || (direction.get(i-1) == 2 && direction.get(i+1) == 2)) {
					smallyindex = i;
				}
			}
		}
		
		int smallarea = length.get(smallxindex)*length.get(smallyindex);
//		System.out.println(smallarea);
		area = area - smallarea;
//		System.out.println(area);
		System.out.println(area*K);
	}

}

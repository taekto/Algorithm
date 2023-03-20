import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			List<String> list = new ArrayList<>();
			HashSet<Integer> result = new HashSet<>();

			// N은 4의 배수이고, 8이상 28이하의 정수이다. (8 ≤ N ≤ 28)       
			// K 번째로 큰수 
			int N = sc.nextInt();
			int K = sc.nextInt();
			// N개의 숫자 입력받기
			String str = sc.next();
			//배열 만들기
			int index = 0;
			
			// 배열안에 값넣기
			for(int i=0;i<N;i++) {
				list.add(String.valueOf(str.charAt(index++)));
			}

			
			// 0회전 배열의 값 저장
			for(int i=0;i<4;i++) {
				String strplus = "";
				for(int j=i*(N/4);j<(N/4)+i*(N/4);j++) {
					strplus += list.get(j);
				}
				result.add(Integer.parseInt(strplus, 16));
			}
			
			
			for(int a=0;a<N/4;a++) {
				list.add(0, list.get(list.size()-1));
				list.remove(list.size()-1);
				for(int i=0;i<4;i++) {
					String strplus = "";
					for(int j=i*(N/4);j<(N/4)+i*(N/4);j++) {
						strplus += list.get(j);
					}
					result.add(Integer.parseInt(strplus, 16));
				}
			}
			
			
			ArrayList<Integer> resultlist = new ArrayList<>(result);
			resultlist.sort(null);
			System.out.println("#"+tc+" "+resultlist.get(resultlist.size()-K));
			
		}
	}
}
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static int[] parent = new int[101];
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
		
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 사람수 N , 관계수 M
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 자기자신으로 초기화 하기
			for(int i=1;i<=N;i++) {
				parent[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				unionParent(a, b);
			}
			
			HashSet<Integer> check = new HashSet<>();
			for(int i=1;i<=N;i++) {
				check.add(findParent(i));
			}
			System.out.println("#"+tc+" "+check.size());
		}
	}
}

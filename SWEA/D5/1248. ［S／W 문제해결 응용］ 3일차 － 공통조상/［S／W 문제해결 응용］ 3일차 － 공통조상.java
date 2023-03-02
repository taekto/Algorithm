import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 T
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 각 케이스의 첫 번째 줄에는 정점의 개수 V(10 ≤ V ≤ 10000)와 간선의 개수 E, 공통 조상을 찾는 두 개의 정점 번호가 주어진다.
			int V = sc.nextInt();
			int E = sc.nextInt();
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int arr[] = new int[V+1];
			
			for(int i=0;i<E;i++) {
				int number = sc.nextInt();
				int index = sc.nextInt();
				arr[index] = number;
			}
			
			List<Integer> num1group = new ArrayList<>();
			List<Integer> num2group = new ArrayList<>();
			
			while(arr[num1] != 0) {
				num1group.add(arr[num1]);
				num1 = arr[num1];
			}
			
			while(arr[num2] != 0) {
				num2group.add(arr[num2]);
				num2 = arr[num2];
			}

			// 공통조상 찾기
			int parent = 0;
//			outer :for(int i=0;i<num1group.size();i++) {
//				for(int j=0;j<num2group.size();j++) {
//					if(num1group.get(i) == num2group.get(j)) {
//						parent = num1group.get(i);
//						break outer;
//					}
//				}
//			}
			List<Integer> parentnode = new ArrayList<>();
//			// 이거는 안됨
//			outer : for(int i=0;i<num1group.size();i++) {
//				for(int j=0;j<num2group.size();j++) {
//					if(num1group.get(i) == num2group.get(j)) {
//						parentnode.add(num2group.get(i));
//					}
//				}
//			}
			// 이거는 됨
			outer : for(int i=0;i<num1group.size();i++) {
				for(int j=0;j<num2group.size();j++) {
					if(num1group.get(i).equals(num2group.get(j))) {
						parent = num1group.get(i);
						break outer;
					}
				}
			}
//			parentnode.sort(null);
//			parent = parentnode.get(parentnode.size()-1);
			
			// 서브트리 크기 찾기
			HashSet<Integer> treesize = new HashSet<>();
			for(int i=arr.length-1;i>=1;i--) { 
				int a = i;
				while(true) {
					if(arr[a] == parent) {
						treesize.add(i);
						break;
					}
					if(arr[a] == 0) {
						break;
					}
					a = arr[a];
				}
			}
			treesize.add(parent);
//			System.out.println(treesize);
	//		System.out.println(num1group);
//			System.out.println(num2group);
			
//			System.out.println(parentnode);
			System.out.println("#"+tc+" "+parent+" "+treesize.size());
		}
	}
}

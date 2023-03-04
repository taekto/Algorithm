import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 기둥의 갯수 N, N은 1 이상 1,000
		int N = sc.nextInt();
		
		// 기둥높이 담는 arr
		int[] arr = new int[1001];
		
		List<Integer> index = new ArrayList<>();
		
		
		for(int i=0;i<N;i++) {
			// 위치 L , 높이 H
			int L = sc.nextInt();
			int H = sc.nextInt();
			arr[L] = H;
			index.add(L);
		}
		index.sort(null);
		
		
		int leftindex = 0;
		int rightindex = 0;
		int leftheight = 0;
		int rightheight = 0;

		// 왼쪽부터 시작하여 가장 높은거 찾기
		for(int i=0;i<1001;i++) {
			if(arr[i] > leftheight) {
				leftheight = arr[i];
				leftindex = i;
			}
		}
		for(int i=1000;i>=1;i--) {
			if(arr[i] > rightheight) {
				rightheight = arr[i];
				rightindex = i;
			}
		}
		
		int[] warehouse = new int[1001];
		
		int leftbarrier = 0;
		for(int i=1;i<leftindex;i++) {
			int a = arr[i];
			if(arr[i] > leftbarrier) {
				leftbarrier = arr[i];
			}
			warehouse[i] = leftbarrier;
		}
		
		int rightbarrier = 0;
		for(int i=1000;i>rightindex;i--) {
			int a = arr[i];
			if(arr[i] > rightbarrier) {
				rightbarrier = arr[i];
			}
			warehouse[i] = rightbarrier;
		}
		
		for(int i=leftindex;i<=rightindex;i++) {
			warehouse[i] = rightheight;
		}
		int sum = 0;
		for(int i=index.get(0);i<=index.get(index.size()-1);i++) {
			sum += warehouse[i];
		}
		System.out.println(sum);
		
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		int result = 0;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int i=0;i<N;i++) {
			int count = 1;
			for(int j=i;j<N-1;j++) {
				if(arr[j] <= arr[j+1]) {
					count++;
				} else {
					break;
				}
			}
			if(count > result) {
				result = count;
			}
		}
		
		for(int i=0;i<N;i++) {
			int count = 1;
			for(int j=i;j<N-1;j++) {
				if(arr[j] >= arr[j+1]) {
					count++;
				} else {
					break;
				}
			}
			if(count > result) {
				result = count;
			}
		}
		
		System.out.println(result);
	}
}

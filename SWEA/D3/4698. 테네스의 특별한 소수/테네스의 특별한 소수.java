import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] arr = new boolean[1000001];
		arr[0] = arr[1] = false;
		// 초기화
		for(int i=2;i<=1000000;i++) {
			arr[i] = true;
		}
		
		for(int i=2;i*i<=1000000;i++) {
			for(int j=i*i;j<=1000000;j+=i) {
				arr[j] = false;
			}
		}
//        System.out.println("Prime number list from 2 to " + 1000000 + " : ");
//        for(int i=0; i<=1000000; i+=1) {
//            if(true == arr[i]) {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();
		
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			// D, A , B
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int numcount = 0;
			for(int j=A;j<=B;j++) {
				String str = String.valueOf(j);
				if(arr[j] == true && str.contains(String.valueOf(D))) {
					numcount++;
				}
			}
			System.out.println("#"+i+" "+numcount);
		}
		
	}
	
	public void Eratostenes() {
		boolean[] arr = new boolean[1000001];
		arr[0] = arr[1] = false;
		// 초기화
		for(int i=2;i<=1000000;i++) {
			arr[i] = true;
		}
		
		for(int i=2;i*i<=1000000;i++) {
			for(int j=i*i;j<=1000000;j+=i) {
				arr[j] = false;
			}
		}
		
	}
}

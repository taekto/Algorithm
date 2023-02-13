package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1204_최빈수구하기_박기택 {
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// testcase T
		for(int i=1;i<=T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<1000;j++) {
				arr[Integer.parseInt(st.nextToken())] += 1;
			}
			int[] newarr = Arrays.copyOf(arr, 101);
			
			System.out.println(Arrays.toString(newarr));
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100-j;k++) {
					if(newarr[k] > newarr[k+1]) {
						int num = newarr[k];
						newarr[k] = newarr[k+1];
						newarr[k+1] = num;
					}
					
				}
			}
			System.out.println(Arrays.toString(newarr));
			System.out.println(Arrays.toString(arr));
			
			for(int j=100;j>=0;j--) {
				if(arr[j] == newarr[newarr.length-1]) {
					System.out.println("#"+i+" "+j);
					break;
				}

			}
			
			
			
		}
		
		
	}

}

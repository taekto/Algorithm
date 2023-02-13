package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1206_taekto {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Test case T
		int T = 10;
		
		
		for(int i=1;i<=T;i++) {
			// 건물의 갯수 N
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				
				arr[j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(arr));
			
			int sum = 0;
			for(int j=2;j<N-2;j++) {
				List<Integer> list = new ArrayList<>();
				if(arr[j]-arr[j-2]>0 & arr[j]-arr[j-1]>0 & arr[j]-arr[j+1]>0 & arr[j]-arr[j+2] >0 ) {
					
					list.add(arr[j]-arr[j-2]);
					list.add(arr[j]-arr[j-1]);
					list.add(arr[j]-arr[j+1]);
					list.add(arr[j]-arr[j+2]);
					list.sort(null);
					
					sum += list.get(0);
				}
				
			}
			System.out.println("#"+i+" "+sum);
			
			
			
		}
		
	}

}

package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1215_회문1_박기택 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<=10;i++) {
			
			int N = Integer.parseInt(br.readLine());
			
			String[][] arr = new String[8][8];
			
			for(int j=0;j<8;j++) {
				String str = br.readLine();
				for(int k=0;k<8;k++) {
					arr[j][k] = String.valueOf(str.charAt(k));
				}
			}
			int result = 0;
			
			// 가로
			
			for(int j=0;j<8;j++) {
				for(int k=0;k<8-N+1;k++) {
					String[] testarr = new String[N]; 
					for(int m=0;m<N;m++) {
						testarr[m] = arr[j][m+k];
					}
					int count = 0;
					for(int m=0;m<N/2;m++) {
						if(testarr[m].equals(testarr[N-1-m])) {
							count +=1;
						}
					}
					if(count == N/2) {
						result +=1;
					}
				}
			}
			// 세로
			for(int j=0;j<8;j++) {
				for(int k=0;k<8-N+1;k++) {
					String[] testarr = new String[N]; 
					for(int m=0;m<N;m++) {
						testarr[m] = arr[m+k][j];
					}
					int count = 0;
					for(int m=0;m<N/2;m++) {
						if(testarr[m].equals(testarr[N-1-m])) {
							count +=1;
						}
					}
					if(count == N/2) {
						result +=1;
					}
				}
			}
			
			
			System.out.println("#"+i+" "+result);
			

			
		}
		
		
		
	}

}

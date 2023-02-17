package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_1989_초심자_회문_검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			int tf = 0;
			
			for(int j=0;j<(str.length()/2);j++) {
				if(arr[j] == arr[arr.length-1-j]) {
					tf = 1;
				}
				else {
					tf = 0;
				}
			}
			
			System.out.println("#"+i+" "+tf);
			
			
		}
		
		
		
		
	}

}

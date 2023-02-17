package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_1216_회문2_박기택_fail2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<=10;i++) {
			int T = Integer.parseInt(br.readLine());
			String[][] arr = new String[100][100];
			
			for(int j=0;j<100;j++) {
				String str = br.readLine();
				for(int k=0;k<100;k++) {
					arr[j][k] = String.valueOf(str.charAt(k));
				}
			}
			List<Integer> result = new ArrayList<>();
			// 가로
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					List<String> testarr = new ArrayList<>();
					for(int n=0;n<100;n++) {
						for(int m=99;m>=0;m--) {
							if( n+m < 100 && n+m >= 0) {
								testarr.add(arr[k][n+m]);
							}
						}
						int count = 0;
						for(int m=0;m<testarr.size()/2;m++) {
							if(testarr.get(m).equals(testarr.get(testarr.size()-1-m))) {
								count += 1;
							}
						}
						if(count == (testarr.size()/2)) {
							result.add(testarr.size());
						}
					}
					
				}
			}
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					List<String> testarr = new ArrayList<>();
					for(int m=99;m>=0;m--) {
						if( k+m < 100 && k+m >=0) {
							testarr.add(arr[k+m][j]);
						}
					}
					int count = 0;
					for(int m=0;m<testarr.size()/2;m++) {
						if(testarr.get(m).equals(testarr.get(testarr.size()-1-m))) {
							count += 1;
						}
					}
					if(count == (testarr.size()/2)) {
						result.add(testarr.size());
					}
					
				}
			}
			result.sort(null);
			
			System.out.println(result.get(result.size()-1));
			
			
			
			
			
		}
	}
}

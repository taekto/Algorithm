package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_1216_회문2_박기택 {
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
			int result = 0;
	        boolean flag = true;
			// 가로
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					for(int m=0;m<100;m++) {
						if(k+m-1<100) {
							for(int n=0;n<m/2;n++) {
								if(!(arr[j][k+n].equals(arr[j][k+m-1-n])))
									flag=false;
							}
							if(flag && m>result) result = m;
							else if(flag == false) flag = true;
						}
					}
				}
			}
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					for(int m=0;m<100;m++) {
						if(k+m-1<100) {
							for(int n=0;n<m/2;n++) {
								if(!(arr[k+n][j].equals(arr[k+m-1-n][j])))
									flag=false;
							}
							if(flag && m>result) result = m;
							else if(flag == false) flag = true;
						}
					}
				}
			}
			
			
			
			
			
			System.out.println(result);
			
			
			
			
			
		}
	}
}

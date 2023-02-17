package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1216_회문2_박기택_fail {
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
			
			System.out.println(Arrays.toString(arr[0]));
			List<Integer> result = new ArrayList<>();
			
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					for(int n=0;n<100;n++) {
						List<String> teststr = new ArrayList<>();
						int count = 0;
						for(int m=0;m<100-n;m++) {
							if(k+m < 100) {
								teststr.add(arr[j][k+m]);
							}
						}
						for(int m=0;n<teststr.size()/2;m++) {
							if(teststr.get(m) == teststr.get(100-1-m)) {
								count += 1;
							}
						}
						if(count == (teststr.size()/2)) {
							result.add(teststr.size());
						}
						
					}
				}
			}
			System.out.println(result);
			
		}
		
	}

}

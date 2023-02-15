package D3;

import java.util.Scanner;

public class Solution_1289_원재의_메모리_복구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int i=1;i<=T;i++) {
            String a = sc.next();
 
            int result = 0;
            boolean tf = true;
 
            for(int j=0;j<a.length();j++) {
                if(a.charAt(j) == '1' && tf == true ) {
                    result += 1;
                    tf = false;
                }
                else if(a.charAt(j) == '0' && tf == false) {
                    result += 1;
                    tf = true;
                }
 
            }
            System.out.println("#"+i+" "+result);
             
        }
         
    }
 
}
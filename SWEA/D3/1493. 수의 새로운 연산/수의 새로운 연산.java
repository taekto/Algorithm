import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int index = 1;
        int num = 1;
        int[][] arr = new int[300][300];
         
        for(int j=0;j<290;j++) {
            for(int k=index;k>=1;k--) {
                for(int m=1;m<=index;m++) {
                    if(k+m == index+1) {
                        arr[k][m] = num++;
                    }
                }
            }
            index++;
        }
        // 테케 T
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
             

            int a = sc.nextInt();
            int b = sc.nextInt();
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;
            outer1 : for(int j=0;j<300;j++) {
                for(int k=0;k<300;k++) {
                    if(a == arr[j][k]) {
                        x1 = k;
                        y1 = j;
                        break outer1;
                    }
                }
            }
             
            outer2 : for(int j=0;j<300;j++) {
                for(int k=0;k<300;k++) {
                    if(b == arr[j][k]) {
                        x2 = k;
                        y2 = j;
                        break outer2;
                    }
                }
            }
            System.out.println("#"+i+" "+arr[y1+y2][x1+x2]);
             
        }
         
    }
}
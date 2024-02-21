import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] arr1;
    static char[] arr2;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        arr1 = new char[s1.length()+1];
        arr2 = new char[s2.length()+1];
        for(int i=1;i<=s1.length();i++) {
            arr1[i] = s1.charAt(i-1);
        }
        for(int i=1;i<=s2.length();i++) {
            arr2[i] = s2.charAt(i-1);
        }
        num = new int[arr2.length+1][arr1.length+1];

        for(int i=1;i<=arr2.length-1;i++) {
            for(int j=1;j<=arr1.length-1;j++) {
                char a = arr2[i];
                char b = arr1[j];
                if(a == b) num[i][j] = num[i-1][j-1]+1;
                else num[i][j] = Math.max(num[i][j-1], num[i-1][j]);
            }
        }

//        for(int i=1;i<=arr2.length-1;i++) {
//            for(int j=1;j<=arr1.length-1;j++) {
//                System.out.print(num[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(num[arr2.length-1][arr1.length-1]);

    }
}
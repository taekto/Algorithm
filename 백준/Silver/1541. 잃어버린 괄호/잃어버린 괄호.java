import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static List<String> list = new ArrayList<>();

    static boolean isNumber(char s) {
        if(s == '+' || s == '-') return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String str = "";
        for(int i=0;i<s.length();i++) {
            char a = s.charAt(i);
            if(!isNumber(a)) {
                str+= String.valueOf(a);
            }
            else {
                list.add(str);
                str = "";
                list.add(String.valueOf(a));
            }
            if(i == s.length()-1) list.add(str);
        }
        int ans = 0;
        int sum = 0;
        for(int i=list.size()-1;i>=0;i--) {
            String a = list.get(i);
            if(a.equals("-")) {
                ans = ans - sum;
                sum = 0;
            }
            else if(a.equals("+")) {

            }
            else {
                sum += Integer.parseInt(a);
            }
        }
        ans += sum;
        System.out.println(ans);
    }
}
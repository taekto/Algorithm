import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            if(value.equals("enter")) {
                map.put(key,value);
            }
            else {
                map.remove(key);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, Collections.reverseOrder());
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }
}
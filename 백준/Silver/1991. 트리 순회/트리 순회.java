import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[] leftChild;
    static char[] rightChild;
    static HashMap<Character, Integer> hashMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static void preorder(char a) {
        int k = hashMap.get(a);
        sb.append(a);
        if(leftChild[k] != '.') preorder(leftChild[k]);
        if(rightChild[k] != '.') preorder(rightChild[k]);

    }

    static void inorder(char a) {
        int k = hashMap.get(a);
        if(leftChild[k] != '.') inorder(leftChild[k]);
        sb.append(a);
        if(rightChild[k] != '.') inorder(rightChild[k]);

    }

    static void postorder(char a) {
        int k = hashMap.get(a);
        if(leftChild[k] != '.') postorder(leftChild[k]);
        if(rightChild[k] != '.') postorder(rightChild[k]);
        sb.append(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        leftChild = new char[N+1];
        rightChild = new char[N+1];


        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);
            hashMap.put(root,i);
            leftChild[i] = lc;
            rightChild[i] = rc;
        }
        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        System.out.println(sb.toString());

    }
}
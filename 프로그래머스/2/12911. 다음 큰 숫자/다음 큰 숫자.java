class Solution {
    
    static int func(int a) {
        int count = 0;
        String s = "";
        
        while(a > 0) {
            int b = a%2;
            if(b == 1) count++;
            a/=2;
        }
        
        return count;
    }
    
    public int solution(int n) {
        int answer = 0;
        int num = func(n);
        
        for(int i=n+1;i<=1000000;i++) {
            if(func(i) == num) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
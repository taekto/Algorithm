class Solution {
    
    static int[] arr = new int[100001];
    
    static int func(int n) {
        if(n <= 1) return arr[n];
        else if(arr[n] != 0) return arr[n];
        else return arr[n] = (func(n-1)+func(n-2))%1234567;
    }
    
    public int solution(int n) {
        int answer = 0;
        arr[0] = 0;
        arr[1] = 1;
        answer = func(n);
        return answer;
    }
}
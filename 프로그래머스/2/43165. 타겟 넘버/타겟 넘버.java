class Solution {
    static int[] arr;
    static int ans = 0;
    static void func(int depth, int[] numbers, int target) {
        if(depth == arr.length) {
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                if(arr[i] == 0) sum += numbers[i];
                else sum -= numbers[i];
            }
            if(sum == target) ans++;
            return;
        }
        
        for(int i=0;i<2;i++) {
            arr[depth] = i;
            func(depth+1, numbers, target);
        }
        
    }
    
    public int solution(int[] numbers, int target) {
        arr = new int[numbers.length];
        func(0, numbers, target);
        return ans;
    }
}
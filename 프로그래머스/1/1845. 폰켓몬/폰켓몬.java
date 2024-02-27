import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            }
        }
        int answer = 0;
        if(hashSet.size() >= nums.length/2) {
            answer = nums.length/2;
        }
        else {
            answer = hashSet.size();
        }
        return answer;
    }
}
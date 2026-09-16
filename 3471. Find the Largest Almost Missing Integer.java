class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0 ; i <= n - k ; i++) {
            Set<Integer> seen = new HashSet<>();
            for(int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }
            for (int num : seen) {
                countMap.put(num , countMap.getOrDefault(num, 0) + 1);
            }
        }
        int result = -1;
        for (int num : countMap.keySet()) {
            if(countMap.get(num) == 1) {
                result = Math.max(result, num);
            }
        }
        return result;
    }
}
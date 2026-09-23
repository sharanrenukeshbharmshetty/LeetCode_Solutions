class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);

        for(int num : nums) {
            sum += num;

            int remainder = (sum % k + k) % k;

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;


    }
    public static void main(String [] args){
        Solution sol = new Solution();
        System.out.println(sol.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5)); 
        System.out.println(sol.subarraysDivByK(new int[]{5}, 9)); 
        System.out.println(sol.subarraysDivByK(new int[]{-1,2,9}, 2)); 
    
    }

}
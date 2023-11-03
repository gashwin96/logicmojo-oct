//brute force
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++) {
                if(i!=0 && nums[i]==nums[i-1]) {
                    continue;
                }
            for(int j = i+1; j<nums.length-1; j++) {
                if(j-1>i && nums[j]==nums[j-1]) {
                    continue;
                }
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] + nums[j] +nums[k] == 0) {
                         res.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                        break;
                    }
                }
            }
        }

        return res;
    }
}


//optimal
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums); //nlogn
        for(int i = 0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left<nums.length && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if(sum>0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
